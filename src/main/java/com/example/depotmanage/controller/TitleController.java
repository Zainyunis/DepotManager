package com.example.depotmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.depotmanage.common.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

import com.example.depotmanage.service.ITitleService;
import com.example.depotmanage.entity.Title;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dzy
 * @since 2022-04-22
 */
@RestController
@RequestMapping("/title")
public class TitleController {

    @Resource
    private ITitleService titleService;

    @PostMapping
    public Result save(@RequestBody Title title) {
        // 新增
        return Result.success(titleService.saveOrUpdate(title));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        // 删除单个
        return Result.success(titleService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        // 批量删除
        return Result.success(titleService.removeBatchByIds(ids));
    }

    @GetMapping("/")
    public Result findAll() {
        // 查询所有
        return Result.success(titleService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        // 根据id查询一条
        return Result.success(titleService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(defaultValue = "") String title) {
        // 分页查询，条件查询
        QueryWrapper<Title> queryWrapper = new QueryWrapper<>();
        if (!"".equals(title)) {
            // 判断是否为空，如果为空就不拼接命令，不判断的话，查询的数据有缺
            queryWrapper.like("title", title);
        }
        return Result.success(titleService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}
