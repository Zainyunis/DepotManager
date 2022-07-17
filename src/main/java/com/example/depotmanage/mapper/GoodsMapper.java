package com.example.depotmanage.mapper;

import com.example.depotmanage.controller.DTO.GoodsDTO;
import com.example.depotmanage.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dzy
 * @since 2022-04-22
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsDTO> findAllById(Integer houseId);
}
