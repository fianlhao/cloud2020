package com.finalhao.springcloud.controller;


import com.finalhao.CommonResult;
import com.finalhao.Payment;
import com.finalhao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @date:2020/8/19 18:46
 * @author:hao.fang Email:
 * Description:
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/save")
    public CommonResult save(@RequestBody Payment payment){
        int res = paymentService.save(payment);
        if (res > 0) {
            return new CommonResult( 0, "插入数据成功 == > " + port, res);
        } else {
            return new CommonResult(1, "插入数据失败  == > " + port, null);
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment) {
            return new CommonResult(0, "查询成功 ==> " + port, payment);
        } else {
            return new CommonResult(1, "查询数据为空  ==> " + port, null);
        }
    }
}
