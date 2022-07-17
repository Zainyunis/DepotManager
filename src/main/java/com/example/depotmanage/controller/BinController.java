package com.example.depotmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.depotmanage.common.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

import com.example.depotmanage.service.IBinService;
import com.example.depotmanage.entity.Bin;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dzy
 * @since 2022-04-26
 */
@RestController
@RequestMapping("/bin")
public class BinController {

    @Resource
    private IBinService binService;

    @PostMapping
    public Result save(@RequestBody Bin bin) {
        // 新增
        return Result.success(binService.saveOrUpdate(bin));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        // 删除单个
        return Result.success(binService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        // 批量删除
        return Result.success(binService.removeBatchByIds(ids));
    }

    @GetMapping("/")
    public Result findAll() {
        // 查询所有
        return Result.success(binService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        // 根据id查询一条
        return Result.success(binService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(defaultValue = "") String sn, // 如果不传数据就为空
            @RequestParam(defaultValue = "") String shelfId,
            @RequestParam(defaultValue = "") String isLoad) {

        // 分页查询，条件查询
        QueryWrapper<Bin> queryWrapper = new QueryWrapper<>();
        if (!"".equals(sn)) {
            // 判断是否为空，如果为空就不拼接命令，不判断的话，查询的数据有缺
            queryWrapper.like("sn", sn);
        }
        if (!"".equals(shelfId)) {
            queryWrapper.like("shelf_id", shelfId);
        }
        if (!"".equals(isLoad)) {
            queryWrapper.like("is_load", isLoad);
        }
        return Result.success(binService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }
}
