package com.atwjq.yygh.user.controller.api;

import com.atwjq.yygh.common.result.Result;
import com.atwjq.yygh.common.util.AuthContextHolder;
import com.atwjq.yygh.model.user.UserInfo;
import com.atwjq.yygh.vo.user.LoginVo;
import com.atwjq.yygh.vo.user.UserAuthVo;
import com.atwjq.yygh.user.service.UserInfoService;
import com.atwjq.yygh.user.utils.IpUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-24-18:17
 */
@RestController
@RequestMapping("/api/user")
public class UserInfoApiController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "会员登录")
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo, HttpServletRequest request) {
        loginVo.setIp(IpUtils.getIpAddr(request));
        Map<String, Object> info = userInfoService.login(loginVo);
        System.out.println(info);
        return Result.ok(info);
    }
    //用户认证接口
    @PostMapping("auth/userAuth")
    public Result userAuth(@RequestBody UserAuthVo userAuthVo, HttpServletRequest request) {
        //传递两个参数，第一个参数用户id，第二个参数认证数据vo对象
        userInfoService.userAuth(AuthContextHolder.getUserId(request),userAuthVo);
        return Result.ok();
    }

    //获取用户id信息接口
    @GetMapping("auth/getUserInfo")
    public Result getUserInfo(HttpServletRequest request) {
        Long userId = AuthContextHolder.getUserId(request);
        UserInfo userInfo = userInfoService.getById(userId);
        return Result.ok(userInfo);
    }
}
