package com.atwjq.yygh.cmn.service;

import com.atwjq.yygh.model.cmn.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-15-16:13
 */
public interface DictService extends IService<Dict> {
    //根据数据id查询子数据列表
    List<Dict> findChlidData(Long id);
    /**
     * 导出
     * @param response
     */
    void exportData(HttpServletResponse response);

    void importDictData(MultipartFile file);
    /**
     * 根据上级编码与值获取数据字典名称
     * @param dictCode
     * @param value
     * @return
     */
    String getDictName(String dictCode, String value);

    List<Dict> findChildrenByDictCode(String dictCode);

}
