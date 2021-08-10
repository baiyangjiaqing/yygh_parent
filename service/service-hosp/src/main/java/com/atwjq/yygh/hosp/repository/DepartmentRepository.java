package com.atwjq.yygh.hosp.repository;

import com.atwjq.yygh.model.hosp.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-21-20:20
 */
@Repository
public interface DepartmentRepository extends MongoRepository<Department,String> {

    Department getDepartmentByHoscodeAndDepcode(String hoscode, String depcode);
}