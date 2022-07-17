package com.example.depotmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.depotmanage.common.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

import com.example.depotmanage.service.IGoodsService;
import com.example.depotmanage.entity.Goods;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dzy
 * @since 2022-04-22
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private IGoodsService goodsService;

    @PostMapping
    public Result save(@RequestBody Goods goods) {
        // 新增
        return Result.success(goodsService.saveOrUpdate(goods));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        // 删除单个
        return Result.success(goodsService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        // 批量删除
        return Result.success(goodsService.removeBatchByIds(ids));
    }

    @GetMapping("/")
    public Result findAll() {
        // 查询所有
        return Result.success(goodsService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        // 根据id查询一条
        return Result.success(goodsService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(defaultValue = "") String name, // 如果不传数据就为空
            @RequestParam(defaultValue = "") String sn,
            @RequestParam(defaultValue = "") String notes) {

        // 分页查询，条件查询
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            // 判断是否为空，如果为空就不拼接命令，不判断的话，查询的数据有缺
            queryWrapper.like("name", name);
        }
        if (!"".equals(sn)) {
            queryWrapper.like("sn", sn);
        }
        if (!"".equals(notes)) {
            queryWrapper.like("notes", notes);
        }
        return Result.success(goodsService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}
