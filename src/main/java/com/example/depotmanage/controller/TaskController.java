package com.example.depotmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.depotmanage.common.Constants;
import com.example.depotmanage.common.Result;
import com.example.depotmanage.entity.Bin;
import com.example.depotmanage.entity.Goods;
import com.example.depotmanage.service.IBinService;
import com.example.depotmanage.service.IGoodsService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import com.example.depotmanage.service.ITaskService;
import com.example.depotmanage.entity.Task;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dzy
 * @since 2022-05-05
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Resource
    private ITaskService taskService;

    @Resource
    private IBinService binService;

    @Resource
    private IGoodsService goodsService;

    @PostMapping("/save")
    public Result save(@RequestBody Task task) {
        String taskNo = task.getTaskNo();
        Integer type = task.getType();
        String binSn = task.getBinSn();
        String goodsSn = task.getGoodsSn();
        Date taskTime = task.getTaskTime();
        Integer amount = task.getAmount();
        String goodsName = task.getGoodsName();
        // 新增
        QueryWrapper<Task> taskWrapper = new QueryWrapper<>();
        boolean one;
        try {
            one = taskService.saveOrUpdate(task);
        } catch (Exception e) {
            return Result.error(Constants.CODE_400, "参数不全,操作失败");
        }
        QueryWrapper<Bin> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("SN", binSn);
        Bin bin = binService.getOne(queryWrapper);
        if (bin == null) {
            taskWrapper.eq("task_no", taskNo);
            taskService.remove(taskWrapper);
            return Result.error(Constants.CODE_400, "库位参数错误,操作失败");
        }
        if (type == 0 && bin.getIsLoad() == 1) {// 出库
            bin.setIsLoad(0);
            bin.setAmount(0);
            bin.setGoodsSn("");
            bin.setOperationDate(taskTime);
            binService.updateById(bin);
        } else if (task.getType() == 1 && bin.getIsLoad() == 0) {
            bin.setIsLoad(1);
            bin.setAmount(amount);

            if (StringUtils.isBlank(goodsName) || StringUtils.isBlank(goodsSn)) {
                taskWrapper.eq("task_no", taskNo);
                taskService.remove(taskWrapper);
                return Result.error(Constants.CODE_400, "参数不全,操作失败");
            }
            QueryWrapper<Goods> goodsWrapper = new QueryWrapper<>();
            goodsWrapper.eq("SN", goodsSn);
            Goods goods = goodsService.getOne(goodsWrapper);
            if (goods == null) {
                Goods o = new Goods();
                o.setName(goodsName);
                o.setSn(goodsSn);
                goodsService.save(o);
            }
            bin.setGoodsSn(goodsSn);
            bin.setOperationDate(taskTime);
            binService.updateById(bin);
        } else {
            taskWrapper.eq("task_no", taskNo);
            taskService.remove(taskWrapper);
            return Result.error(Constants.CODE_400, "参数不正确,操作失败");
        }
        return Result.success(one);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        // 删除单个
        return Result.success(taskService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        // 批量删除
        return Result.success(taskService.removeBatchByIds(ids));
    }

    @GetMapping("/")
    public Result findAll() {
        // 查询所有
        return Result.success(taskService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        // 根据id查询一条
        return Result.success(taskService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(defaultValue = "") String taskNo, // 如果不传数据就为空
            @RequestParam(defaultValue = "") String taskType,
            @RequestParam(defaultValue = "") String binSn, // 如果不传数据就为空
            @RequestParam(defaultValue = "") String userName,
            @RequestParam(defaultValue = "") String goodsSn, // 如果不传数据就为空
            @RequestParam(defaultValue = "") String goodsName) {
        // 分页查询，条件查询
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
        if (!"".equals(taskNo)) {
            // 判断是否为空，如果为空就不拼接命令，不判断的话，查询的数据有缺
            queryWrapper.like("task_no", taskNo);
        }
        if (!"".equals(taskType)) {
            queryWrapper.like("type", taskType);
        }
        if (!"".equals(binSn)) {
            // 判断是否为空，如果为空就不拼接命令，不判断的话，查询的数据有缺
            queryWrapper.like("bin_id", binSn);
        }
        if (!"".equals(userName)) {
            queryWrapper.like("username", userName);
        }
        if (!"".equals(goodsSn)) {
            // 判断是否为空，如果为空就不拼接命令，不判断的话，查询的数据有缺
            queryWrapper.like("goods_sn", goodsSn);
        }
        if (!"".equals(goodsName)) {
            queryWrapper.like("goods_name", goodsName);
        }
        return Result.success(taskService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}
