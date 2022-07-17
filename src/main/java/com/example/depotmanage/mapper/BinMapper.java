package com.example.depotmanage.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.depotmanage.controller.DTO.BinDTO;
import com.example.depotmanage.entity.Bin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dzy
 * @since 2022-04-26
 */
public interface BinMapper extends BaseMapper<Bin> {

    BinDTO findOneBySn(String binSn);

    Page<BinDTO> findPage(Page<BinDTO> page,
                          @Param("houseName") String houseName,
                          @Param("houseSn") String houseSn,
                          @Param("shelfSn") String shelfSn,
                          @Param("binSn") String binSn,
                          @Param("isLoad") Integer isLoad,
                          @Param("goodsName") String goodsName,
                          @Param("goodsSn") String goodsSn,
                          @Param("goodsNotes") String goodsNotes,
                          @Param("operationDate") String operationDate);
}








