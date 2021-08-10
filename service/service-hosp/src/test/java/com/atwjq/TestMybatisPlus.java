package com.atwjq;

import com.atwjq.yygh.hosp.ServiceHospApplication;
import com.atwjq.yygh.hosp.service.HospitalSetService;
import com.atwjq.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-06-14:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceHospApplication.class)
public class TestMybatisPlus {
    @Autowired
    private HospitalSetService hospitalSetService;
    @Autowired
    private DataSource dataSource;

    @Test
    public void testDatasource() throws SQLException {
        System.out.println(dataSource.getClass().getName());
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testMybatisPlus() {
        Page<HospitalSet> page = new Page<>(0,3);
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        Page<HospitalSet> hospitalSetPage = hospitalSetService.page(page, queryWrapper);
        System.out.println(hospitalSetPage);
    }

    @Test
    public void testMybatisPlus_byAT(){
        int i = hospitalSetService.lockHospitalSet(2, 1);
    }
}
