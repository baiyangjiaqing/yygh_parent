package com.atwjq.yygh.hosp.service;

import com.atwjq.yygh.model.hosp.HospitalSet;
import com.atwjq.yygh.vo.order.SignInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-05-18:39
 */
public interface HospitalSetService extends IService<HospitalSet> {
    int lockHospitalSet(long id,long status);
    /**
     * 获取签名key
     * @param hoscode
     * @return
     */
    String getSignKey(String hoscode);

    SignInfoVo getSignInfoVo(String hoscode);
}
