package com.example.depotmanage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.depotmanage.controller.DTO.BinDTO;
import com.example.depotmanage.entity.Bin;
import com.example.depotmanage.mapper.BinMapper;
import com.example.depotmanage.service.IBinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dzy
 * @since 2022-04-26
 */
@Service
public class BinServiceImpl extends ServiceImpl<BinMapper, Bin> implements IBinService {

    @Resource
    private BinMapper binMapper;


    @Override
    public BinDTO findOneBySn(String binSn) {
        return binMapper.findOneBySn(binSn);
    }

    @Override
    public IPage<BinDTO> findPage(Page<BinDTO> page, String houseName, String houseSn, String shelfSn, String binSn, Integer isLoad, String goodsName, String goodsSn, String goodsNotes, String operationDate) {
        return binMapper.findPage(page,houseName, houseSn, shelfSn, binSn,isLoad, goodsName, goodsSn, goodsNotes, operationDate);

    }
}
