package com.atwjq.yygh.common.util;

import com.atwjq.yygh.common.help.JwtHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-29-16:58
 */
//获取当前用户信息工具类
public class AuthContextHolder {
    //获取当前用户id
    public static Long getUserId(HttpServletRequest request) {
        //从header获取token
        String token = request.getHeader("token");
        //jwt从token获取userid
        Long userId = JwtHelper.getUserId(token);
        return userId;
    }
    //获取当前用户名称
    public static String getUserName(HttpServletRequest request) {
        //从header获取token
        String token = request.getHeader("token");
        //jwt从token获取userid
        String userName = JwtHelper.getUserName(token);
        return userName;
    }
}