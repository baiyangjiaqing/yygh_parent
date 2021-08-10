package com.atwjq.yygh.msm.service;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-26-2:58
 */
public interface MsmService {
    //发送手机验证码
    boolean send(String phone, String code);
}
