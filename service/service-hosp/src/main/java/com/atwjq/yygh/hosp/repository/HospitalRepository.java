package com.atwjq.yygh.hosp.repository;

import com.atwjq.yygh.model.hosp.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-20-10:31
 */
@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {
    //判断是否存在数据
    Hospital getHospitalByHoscode(String hoscode);

    Hospital getHospitalById(String id);

    //根据医院名称查询
    List<Hospital> findHospitalByHosnameLike(String hosname);
}
