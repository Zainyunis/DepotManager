package com.example.depotmanage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.depotmanage.controller.DTO.BinDTO;
import com.example.depotmanage.entity.Bin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dzy
 * @since 2022-04-26
 */
public interface IBinService extends IService<Bin> {
    

    BinDTO findOneBySn(String binSn);

    IPage<BinDTO> findPage(Page<BinDTO> page, String houseName, String houseSn, String shelfSn, String binSn, Integer isLoad, String goodsName, String goodsSn, String goodsNotes, String operationDate);
}
