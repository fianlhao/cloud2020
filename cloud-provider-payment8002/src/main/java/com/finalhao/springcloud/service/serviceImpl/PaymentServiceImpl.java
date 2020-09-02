package com.finalhao.springcloud.service.serviceImpl;

import com.finalhao.Payment;
import com.finalhao.springcloud.Dao.PaymentDao;
import com.finalhao.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date:2020/8/19 18:37
 * @author:hao.fang Email:
 * Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }
}
