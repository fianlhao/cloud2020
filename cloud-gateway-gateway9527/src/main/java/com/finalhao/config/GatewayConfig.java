package com.finalhao.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

/**
 * @date:2020/8/23 11:33
 * @author:hao.fang Email:
 * Description:
 */
@Configuration
public class GatewayConfig {

    public RouteLocator customerRouterLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("pay_routh",
                r -> r.path("/pay").uri("https://news.baidu.com/guonei"))
                .build();
        return routes.build();
    }
}
