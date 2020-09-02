package com.finalhao.springcloud.service;


import com.finalhao.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @date:2020/8/19 18:36
 * @author:hao.fang Email:
 * Description:
 */
public interface PaymentService {
    public int save(Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);
}
