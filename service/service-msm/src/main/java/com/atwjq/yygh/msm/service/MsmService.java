package com.atwjq.yygh.msm.service;

import com.atwjq.yygh.vo.msm.MsmVo;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-26-2:58
 */
public interface MsmService {
    //发送手机验证码
    boolean send(String phone, String code);

    //mq发送短信的接口
    boolean send(MsmVo msmVo);

}
