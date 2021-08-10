package com.atwjq.yygh.hosp.controller;

import com.atwjq.yygh.common.exception.YyghException;
import com.atwjq.yygh.common.help.JwtHelper;
import com.atwjq.yygh.common.result.Result;
import com.atwjq.yygh.common.result.ResultCodeEnum;
import com.atwjq.yygh.hosp.controller.vo.AdminVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-08-10-15:56
 */
@Api(tags = "后台登录相关API接口")
@RestController
@RequestMapping("/admin/hosp/user")
public class AdminController {
    @PostMapping("login")
    public Result adminLogin(@RequestBody AdminVo adminVo) {
        String username = adminVo.getUsername();
        String password = adminVo.getPassword();
        if (!"admin".equals(username) || !"765432".equals(password)) {
            throw new YyghException(ResultCodeEnum.ADMIN_LOGIN_ERROR);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("name", username);
        map.put("token", JwtHelper.createToken(Long.getLong(password),username));
        return Result.ok(map);
    }
}
