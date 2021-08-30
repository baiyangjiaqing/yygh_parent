package com.atwjq.yygh.order.service;


import com.atwjq.yygh.model.order.PaymentInfo;
import com.atwjq.yygh.model.order.RefundInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface RefundInfoService extends IService<RefundInfo> {

    /**
     * 保存退款记录
     * @param paymentInfo
     */
    RefundInfo saveRefundInfo(PaymentInfo paymentInfo);

}
