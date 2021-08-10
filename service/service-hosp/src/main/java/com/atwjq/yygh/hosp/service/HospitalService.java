package com.atwjq.yygh.hosp.service;

import com.atwjq.yygh.model.hosp.Hospital;
import com.atwjq.yygh.vo.hosp.HospitalQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-20-10:33
 */
public interface HospitalService {
    /**
     * 上传医院信息
     * @param paramMap
     */
    void save(Map<String, Object> paramMap);

    Hospital getByHoscode(String hoscode);
    Hospital getById(String id);
    /**
     * 分页查询
     * @param page 当前页码
     * @param limit 每页记录数
     * @param hospitalQueryVo 查询条件
     * @return
     */
    Page<Hospital> selectPage(Integer page, Integer limit, HospitalQueryVo hospitalQueryVo);
    /**
     * 更新上线状态
     */
    void updateStatus(String id, Integer status);
    /**
     * 医院详情
     * @param id
     * @return
     */
    Map<String, Object> show(String id);

    String getHospName(String hoscode);

    Page<Hospital> selectHospPage(Integer page, Integer limit, HospitalQueryVo hospitalQueryVo);

    List<Hospital> findByHosname(String hosname);

    Map<String, Object> item(String hoscode);
}
