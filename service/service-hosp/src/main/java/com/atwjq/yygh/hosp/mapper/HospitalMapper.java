package com.atwjq.yygh.hosp.mapper;

import com.atwjq.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-05-18:02
 */
@Mapper
public interface HospitalMapper extends BaseMapper<HospitalSet> {

    @Update("update t_hospital_set set status=#{status} where id=#{id}")
    int lockHospitalSet(long id,long status);
}
