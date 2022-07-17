package com.example.depotmanage.service;

import com.example.depotmanage.controller.DTO.UserDTO;
import com.example.depotmanage.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dzy
 * @since 2022-04-19
 */
public interface IUserService extends IService<User> {
    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);
}
