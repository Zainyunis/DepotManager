package com.example.depotmanage.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.depotmanage.entity.User;
import com.example.depotmanage.service.IUserService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class TokenUtils {

    private static IUserService staticUserService;
    @Resource
    private IUserService userService;

    @PostConstruct
    public void setStaticUserService(){
        staticUserService=userService;
    }

    /**
     * 生成token
     * @return
     */
    public static String genToker(String userId,String sign){
        return  JWT.create().withAudience(userId) // 将 user id 保存到 token 里面,作为载荷
                .withExpiresAt(DateUtils.addHours(new Date(),2)) //2小时后token过期
                .sign(Algorithm.HMAC256(sign)); // 以 password 作为 token 的密钥
    }

    /**
     * 获取当前用户信息
     * @return
     */
    public static User gerCurrentUser(){
        try{
            HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if(StringUtils.isBlank(token)){
                String userId = JWT.decode(token).getAudience().get(0);
                return staticUserService.getById(Integer.valueOf(userId));
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

}
