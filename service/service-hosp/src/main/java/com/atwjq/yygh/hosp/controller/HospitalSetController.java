package com.atwjq.yygh.hosp.controller;

import com.atwjq.yygh.common.result.Result;
import com.atwjq.yygh.common.utils.MD5;
import com.atwjq.yygh.hosp.service.HospitalSetService;
import com.atwjq.yygh.model.hosp.HospitalSet;
import com.atwjq.yygh.vo.hosp.HospitalQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-05-18:44
 */
@RestController
@RequestMapping(value = "/admin/hosp/hospitalSet")
//@CrossOrigin
public class HospitalSetController {
    @Autowired
    private HospitalSetService hospitalSetService;



    @GetMapping("findAll")
    public Result findAllHospitalSet(){
        List<HospitalSet> hospitalSetList = hospitalSetService.list();
        return Result.ok(hospitalSetList);
    }


    //条件查询带分页
    @PostMapping("findHospSetByPage/{current}/{limit}")
    public Result conditionQueryByPage(@PathVariable long current, @PathVariable long limit,@RequestBody(required = false) HospitalQueryVo queryVo) {
        Page<HospitalSet> page = new Page<>(current,limit);
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        String hosName=queryVo.getHosname();
        String hosCode=queryVo.getHoscode();
        if(!StringUtils.isEmpty(hosName)){
            queryWrapper.like("hos_name",queryVo.getHosname());
        }
        if(!StringUtils.isEmpty(hosCode)){
            queryWrapper.eq("hos_code", queryVo.getHoscode());
        }
        Page<HospitalSet> hospitalSetPage = hospitalSetService.page(page, queryWrapper);
        return Result.ok(hospitalSetPage);
    }

    //添加医院设置
    @PostMapping("saveHospitalSet")
    public Result saveHospitalSet(@RequestBody HospitalSet hospitalSet){
        //设置状态 1使用 0不使用
        hospitalSet.setStatus(1);
        //签名密钥
        Random random = new Random();
        hospitalSet.setSignKey(MD5.encrypt("" + System.currentTimeMillis() + random.nextInt(1000)));
        boolean save = hospitalSetService.save(hospitalSet);
        return save ? Result.ok() : Result.fail();
    }

    //根据id获得医院设置
    @GetMapping("findHospitalById/{id}")
    public Result findHospitalById(@PathVariable long id){
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return hospitalSet != null ? Result.ok(hospitalSet) : Result.fail();
    }

    //修改医院设置
    @PutMapping("updateHospitalSet")
    public Result updateHospitalSet(@RequestBody HospitalSet hospitalSet){
        boolean b = hospitalSetService.updateById(hospitalSet);
        return b ? Result.ok() : Result.fail();
    }

    @DeleteMapping("delete/{id}")
    public Result removeHospital(@PathVariable long id){
        boolean b = hospitalSetService.removeById(id);
        return b==true?Result.ok():Result.fail();
    }


    //批量删除
    @DeleteMapping("batchRemoveHospitalSet")
    public Result batchRemoveHospitalSet(@RequestBody List<Long> idList){
        boolean b = hospitalSetService.removeByIds(idList);
        return b ? Result.ok() : Result.fail();
    }

    //设置锁定
    @PutMapping("lockHospitalSet/{id}/{status}")
    public Result lockHospitalSet(@PathVariable Long id, @PathVariable long status) {
        int i = hospitalSetService.lockHospitalSet(id, status);
        return i >= 1 ? Result.ok() : Result.fail();
    }

    @PutMapping("sendKey/{id}")
    public Result sendHospitalSetKey(@PathVariable long id){
//        try {
//            int i=1/0;
//        } catch (Exception e) {
//            throw new YyghException("分母不能为0",203);
//        }
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        String signKey = hospitalSet.getSignKey();
        //发送短信
        return Result.ok();
    }
}
