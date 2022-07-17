package com.example.depotmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.depotmanage.common.Constants;
import com.example.depotmanage.common.Result;
import com.example.depotmanage.controller.DTO.UserDTO;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

import com.example.depotmanage.service.IUserService;
import com.example.depotmanage.entity.User;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dzy
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        // 登录
        String account = userDTO.getAccount();
        String password = userDTO.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return Result.error(Constants.CODE_400, "参数错误");
        }
        return Result.success(userService.login(userDTO));
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO) {
        // 注册
        String account = userDTO.getAccount();
        String password = userDTO.getPassword();
        String name = userDTO.getName();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password) || StringUtils.isBlank(name)) {
            return Result.error(Constants.CODE_400, "参数错误");
        }
        return Result.success(userService.register(userDTO));
    }

    @GetMapping("/account/{account}")
    public Result findOne(@PathVariable String account) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        return Result.success(userService.getOne(queryWrapper));
    }

    @PostMapping
    public Result save(@RequestBody User user) {
        // 新增
        return Result.success(userService.saveOrUpdate(user));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        // 删除单个
        return Result.success(userService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        // 批量删除
        return Result.success(userService.removeBatchByIds(ids));
    }

    // @GetMapping("/{id}")
    // public Result findOne(@PathVariable Integer id) {
    // //根据id查询一条
    // return Result.success(userService.getById(id));
    // }
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(defaultValue = "") String username, // 如果不传数据就为空
            @RequestParam(defaultValue = "") String account) {
        // 分页查询，条件查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username)) {
            // 判断是否为空，如果为空就不拼接命令，不判断的话，查询的数据有缺
            queryWrapper.like("name", username);
        }
        if (!"".equals(account)) {
            queryWrapper.like("account", account);
        }

        return Result.success(userService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}
