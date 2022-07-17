package com.example.depotmanage.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.depotmanage.common.Result;
import com.example.depotmanage.controller.DTO.BinDTO;
import com.example.depotmanage.controller.DTO.GoodsDTO;
import com.example.depotmanage.service.IBinService;
import com.example.depotmanage.service.IGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Resource
    private IGoodsService goodsService;

    @Resource
    private IBinService binService;

    @GetMapping("/{id}")
    public Result findAllById(@PathVariable Integer id) {
        // 查询某仓库所有物料位置
        List<GoodsDTO> one = goodsService.findAllById(id);
        return Result.success(one);
    }

    @PostMapping("/getData")
    public Result findOneBySn(@RequestBody String binSn) {
        // 查询某仓库所有物料位置
        BinDTO one = binService.findOneBySn(binSn);
        return Result.success(one);
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(defaultValue = "") String houseName,
            @RequestParam(defaultValue = "") String houseSn,
            @RequestParam(defaultValue = "") String shelfSn,
            @RequestParam(defaultValue = "") String binSn,
            @RequestParam(defaultValue = "-1") Integer isLoad,
            @RequestParam(defaultValue = "") String goodsName,
            @RequestParam(defaultValue = "") String goodsSn,
            @RequestParam(defaultValue = "") String goodsNotes,
            @RequestParam(defaultValue = "") String operationDate) {

        // 分页查询，条件查询
        return Result.success(binService.findPage(new Page<>(pageNum, pageSize), houseName, houseSn, shelfSn, binSn,
                isLoad, goodsName, goodsSn, goodsNotes, operationDate));

    }

}
