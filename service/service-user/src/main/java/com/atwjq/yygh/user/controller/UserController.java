package com.atwjq.yygh.user.controller;

import com.atwjq.yygh.common.result.Result;
import com.atwjq.yygh.model.user.UserInfo;
import com.atwjq.yygh.vo.user.UserInfoQueryVo;
import com.atwjq.yygh.user.service.UserInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-29-18:34
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    //用户列表（条件查询带分页）
    @GetMapping("{page}/{limit}")
    public Result list(@PathVariable Long page,
                       @PathVariable Long limit,
                       UserInfoQueryVo userInfoQueryVo) {
        Page<UserInfo> pageParam = new Page<>(page,limit);
        IPage<UserInfo> pageModel =
                userInfoService.selectPage(pageParam,userInfoQueryVo);
        return Result.ok(pageModel);
    }
    @ApiOperation(value = "锁定")
    @GetMapping("lock/{userId}/{status}")
    public Result lock(
            @PathVariable("userId") Long userId,
            @PathVariable("status") Integer status){
        userInfoService.lock(userId, status);
        return Result.ok();
    }

    //用户详情
    @GetMapping("show/{userId}")
    public Result show(@PathVariable Long userId) {
        Map<String,Object> map = userInfoService.show(userId);
        return Result.ok(map);
    }
    //认证审批
    @GetMapping("approval/{userId}/{authStatus}")
    public Result approval(@PathVariable Long userId,@PathVariable Integer authStatus) {
        userInfoService.approval(userId,authStatus);
        return Result.ok();
    }
}