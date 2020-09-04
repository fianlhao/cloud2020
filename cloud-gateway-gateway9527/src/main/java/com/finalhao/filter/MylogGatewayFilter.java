package com.finalhao.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;
import java.util.Date;

/**
 * @date:2020/8/23 11:53
 * @author:hao.fang Email:
 * Description:
 */
//@Component
@Slf4j
public class MylogGatewayFilter implements GlobalFilter, Order {
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**************log*********" + new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (null == username) {
            log.info("***username 为 null，非法用户**********");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int value() {
        return 0;
    }
}
