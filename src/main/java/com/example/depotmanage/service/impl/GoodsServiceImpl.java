package com.example.depotmanage.service.impl;

import com.example.depotmanage.controller.DTO.GoodsDTO;
import com.example.depotmanage.entity.Goods;
import com.example.depotmanage.mapper.GoodsMapper;
import com.example.depotmanage.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dzy
 * @since 2022-04-22
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsDTO> findAllById(Integer houseId) {

        return goodsMapper.findAllById(houseId);
    }
}
