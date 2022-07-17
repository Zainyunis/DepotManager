package com.example.depotmanage.service;

import com.example.depotmanage.controller.DTO.GoodsDTO;
import com.example.depotmanage.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dzy
 * @since 2022-04-22
 */
public interface IGoodsService extends IService<Goods> {

    List<GoodsDTO> findAllById(Integer houseId);
}
