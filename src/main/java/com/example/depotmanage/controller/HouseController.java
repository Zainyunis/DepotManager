package com.example.depotmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.depotmanage.common.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

import com.example.depotmanage.service.IHouseService;
import com.example.depotmanage.entity.House;

/**
 * <p>
 * 仓库信息 前端控制器
 * </p>
 *
 * @author dzy
 * @since 2022-04-22
 */
@RestController
@RequestMapping("/house")
public class HouseController {

    @Resource
    private IHouseService houseService;

    @PostMapping
    public Result save(@RequestBody House house) {
        // 新增
        return Result.success(houseService.saveOrUpdate(house));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        // 删除单个
        return Result.success(houseService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        // 批量删除
        return Result.success(houseService.removeBatchByIds(ids));
    }

    @GetMapping("/")
    public Result findAll() {
        // 查询所有
        return Result.success(houseService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        // 根据id查询一条
        return Result.success(houseService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(defaultValue = "") String name, // 如果不传数据就为空
            @RequestParam(defaultValue = "") String sn) {

        // 分页查询，条件查询
        QueryWrapper<House> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            // 判断是否为空，如果为空就不拼接命令，不判断的话，查询的数据有缺
            queryWrapper.like("name", name);
        }
        if (!"".equals(sn)) {
            queryWrapper.like("SN", sn);
        }
        return Result.success(houseService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}
