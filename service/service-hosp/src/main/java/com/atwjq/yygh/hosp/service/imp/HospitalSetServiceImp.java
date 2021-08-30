package com.atwjq.yygh.hosp.service.imp;

import com.atwjq.yygh.common.result.ResultCodeEnum;
import com.atwjq.yygh.hosp.mapper.HospitalMapper;
import com.atwjq.yygh.hosp.service.HospitalSetService;
import com.atwjq.yygh.model.hosp.HospitalSet;
import com.atwjq.yygh.common.exception.YyghException;
import com.atwjq.yygh.vo.order.SignInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-05-18:40
 */
@Service
public class HospitalSetServiceImp extends ServiceImpl<HospitalMapper, HospitalSet> implements HospitalSetService {
    @Override
    public int lockHospitalSet(long id,long status) {
        return baseMapper.lockHospitalSet(id,status);
    }


    @Override
    public String getSignKey(String hoscode) {
        HospitalSet hospitalSet = this.getByHoscode(hoscode);
        if(null == hospitalSet) {
            throw new YyghException(ResultCodeEnum.HOSPITAL_OPEN);
        }
        if(hospitalSet.getStatus().intValue() == 0) {
            throw new YyghException(ResultCodeEnum.HOSPITAL_LOCK);
        }
        return hospitalSet.getSignKey();
    }

    @Override
    public SignInfoVo getSignInfoVo(String hoscode) {
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        wrapper.eq("hos_code",hoscode);
        HospitalSet hospitalSet = baseMapper.selectOne(wrapper);
        if(null == hospitalSet) {
            throw new YyghException(ResultCodeEnum.HOSPITAL_OPEN);
        }
        SignInfoVo signInfoVo = new SignInfoVo();
        signInfoVo.setApiUrl(hospitalSet.getApiUrl());
        signInfoVo.setSignKey(hospitalSet.getSignKey());
        return signInfoVo;
    }

    /**
     * 根据hoscode获取医院设置
     * @param hoscode
     * @return
     */
    private HospitalSet getByHoscode(String hoscode) {
        return baseMapper.selectOne(new QueryWrapper<HospitalSet>().eq("hos_code", hoscode));
    }
}
