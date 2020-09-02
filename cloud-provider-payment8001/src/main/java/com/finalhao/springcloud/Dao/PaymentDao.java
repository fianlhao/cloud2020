package com.finalhao.springcloud.Dao;

import com.finalhao.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @date:2020/8/19 18:12
 * @author:hao.fang Email:
 * Description:
 */
@Mapper
public interface PaymentDao {
    public int save(Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);
}
