package com.atwjq.yygh.msm.controller;

import com.atwjq.yygh.common.result.Result;
import com.atwjq.yygh.msm.service.MsmService;
import com.atwjq.yygh.msm.utils.RandomUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-26-3:01
 */
@Api("短信接口")
@RestController
@RequestMapping("/api/msm")
public class MsmApiController {

    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //发送手机验证码
    @ApiOperation(value = "发送手机验证码")
    @GetMapping("send/{phone}")
    public Result sendCode(@PathVariable String phone) {
        //从redis获取验证码，如果获取获取到，返回ok
        // key 手机号  value 验证码
        String code = redisTemplate.opsForValue().get(phone);
        if(!StringUtils.isEmpty(code)) {
            return Result.ok();
        }
        //如果从redis获取不到，
        // 生成验证码，
        code = RandomUtils.getSixBitRandom();
        //调用service方法，通过整合短信服务进行发送
//        boolean isSend = msmService.send(phone,code);
        boolean isSend=true;
        //生成验证码放到redis里面，设置有效时间
        if(isSend) {
            System.out.println("保存验证码："+phone+"---"+code);
            redisTemplate.opsForValue().set(phone,code,2, TimeUnit.MINUTES);
            return Result.ok();
        } else {
            return Result.fail().message("发送短信失败");
        }
    }
}