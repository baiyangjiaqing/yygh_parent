package com.atwjq.yygh.cmn.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atwjq.yygh.cmn.mapper.DictMapper;
import com.atwjq.yygh.model.cmn.Dict;
import com.atwjq.yygh.vo.cmn.DictEeVo;
import org.springframework.beans.BeanUtils;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-16-19:43
 */
public class DictListener extends AnalysisEventListener<DictEeVo> {
    private DictMapper dictMapper;

    public DictListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    //一行行读取
    @Override
    public void invoke(DictEeVo dictEeVo, AnalysisContext analysisContext) {
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictEeVo,dict);
        dictMapper.insert(dict);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
