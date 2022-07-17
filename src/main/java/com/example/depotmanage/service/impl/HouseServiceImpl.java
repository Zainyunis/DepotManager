package com.example.depotmanage.service.impl;

import com.example.depotmanage.entity.House;
import com.example.depotmanage.mapper.HouseMapper;
import com.example.depotmanage.service.IHouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 仓库信息 服务实现类
 * </p>
 *
 * @author dzy
 * @since 2022-04-22
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {

}
