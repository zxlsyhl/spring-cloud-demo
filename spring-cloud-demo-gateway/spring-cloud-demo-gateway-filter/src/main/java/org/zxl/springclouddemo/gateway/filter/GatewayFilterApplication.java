package org.zxl.springclouddemo.gateway.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.zxl.springclouddemo.gateway.filter.filter.RequestTimeFilter;
import org.zxl.springclouddemo.gateway.filter.filterfactory.RequestTimeGatewayFilterFactory;
import org.zxl.springclouddemo.gateway.filter.global.TokenFilter;

@SpringBootApplication
@RestController
@Configuration
public class GatewayFilterApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayFilterApplication.class,args);
    }

    //向IOC中注册自定义的过滤器。
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/helloAdd")
                            .filters(f -> f.filter(new RequestTimeFilter()))
                            .uri("http://localhost:3333")
                            .order(0)
                        .id("customer_filter_router")
                ).build();
    }

    //向IOC中注册自定义过滤器工厂，使可以在配置文件中使用
    @Bean
    public RequestTimeGatewayFilterFactory requestTimeGatewayFilterFactory(){
        return new RequestTimeGatewayFilterFactory();
    }

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

}
