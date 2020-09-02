package com.finalhao.lock;

import org.redisson.Redisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date:2020/9/2 0:08
 * @author:hao.fang Email:
 * Description:
 */
@RestController
public class IndexController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /*@Autowired
    private Redisson redisson;*/

    @RequestMapping("/deduct_stock")
    public String deductStock() {
        synchronized (this) {
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减库存成功，剩余库存为：" + realStock);
            } else {
                System.out.println("扣减库存失败，库存不足！");
            }
        }

        return "end";
    }

}
