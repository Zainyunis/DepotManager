package com.example.depotmanage.config.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.depotmanage.common.Constants;
import com.example.depotmanage.entity.User;
import com.example.depotmanage.exception.ServiceException;
import com.example.depotmanage.service.IUserService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

    /**
     *
     */
    private static final boolean BOOLEAN = true;
    @Resource
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("token");

        // System.out.println("*******\n\n\n\n\n");
        // System.out.println(token);
        // System.out.println("*******\n\n\n\n\n");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 执行认证
        if (StringUtils.isBlank(token)) {
            throw new ServiceException(Constants.CODE_401, "无token，请重新登陆");
        }
        // 获取token中的userid
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录");
        }
        // 根据token中的userid查询数据库
        User user = userService.getById(userId);
        if (user == null) {
            throw new ServiceException(Constants.CODE_401, "用户不存在，请重新登录");
        }
        // 用户密码加签验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);// 验证token
        } catch (JWTVerificationException e) {
            throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录");
        }
        return BOOLEAN;
    }
}
