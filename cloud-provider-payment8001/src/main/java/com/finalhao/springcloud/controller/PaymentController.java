package com.finalhao.springcloud.controller;


import com.finalhao.CommonResult;
import com.finalhao.Payment;
import com.finalhao.springcloud.service.PaymentService;
import com.netflix.discovery.shared.Applications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private DiscoveryClient discoveryClient;
    @PostMapping("/payment/save")
    public CommonResult save(@RequestBody Payment payment){
        int res = paymentService.save(payment);
        if (res > 0) {
            return new CommonResult( 0, "插入数据成功 == > " + port, res);
        } else {
            return new CommonResult(1, "插入数据失败 == > " + port, null);
        }

    }

    @PostMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment) {
            return new CommonResult(0, "查询成功 ===> " + port, payment);
        } else {
            return new CommonResult(1, "查询数据为空 ====> " + port, null);
        }
    }

    @GetMapping("payment/discovey")
    public Object getClient() {
        List<String> services = discoveryClient.getServices();//拿到所有的注册信息
        for (String service : services) {
            log.info("************servie*******", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
