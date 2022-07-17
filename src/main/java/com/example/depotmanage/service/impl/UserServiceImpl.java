package com.example.depotmanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.depotmanage.common.Constants;
import com.example.depotmanage.controller.DTO.UserDTO;
import com.example.depotmanage.entity.User;
import com.example.depotmanage.exception.ServiceException;
import com.example.depotmanage.mapper.UserMapper;
import com.example.depotmanage.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.depotmanage.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dzy
 * @since 2022-04-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserDTO login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",userDTO.getAccount());
        queryWrapper.eq("password",userDTO.getPassword());
        User one;
        try{
            one = getOne(queryWrapper);
        }catch (Exception e){
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        if(one!=null){
            if(one.getVisitPower()==1)
                throw new ServiceException(Constants.CODE_401,"用户已被禁用，请联系管理员处理");
            else{
                BeanUtils.copyProperties(one,userDTO);
                //设置token
                String token = TokenUtils.genToker(one.getId().toString(),one.getPassword());
                userDTO.setToken(token);
                return userDTO;
            }
        }else{
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }

    @Override
    public User register(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",userDTO.getAccount());
        User one;
        try{
            one = getOne(queryWrapper);
        }catch (Exception e){
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        if(one!=null){
            throw new ServiceException(Constants.CODE_600,"用户已存在");
        }else{
            one = new User();
            BeanUtils.copyProperties(userDTO,one);
            save(one);
            return one;
        }
    }
}
