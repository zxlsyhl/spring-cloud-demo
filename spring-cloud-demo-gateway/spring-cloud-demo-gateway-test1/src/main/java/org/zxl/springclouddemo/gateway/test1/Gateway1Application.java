package org.zxl.springclouddemo.gateway.test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Gateway1Application {
    public static void main(String[] args) {
        SpringApplication.run(Gateway1Application.class,args);
    }
    @Bean
    public RouteLocator myRotes(RouteLocatorBuilder builder){
        return builder.routes().
                route(p-> p.
                        path("/helloAdd").
                        filters(f -> f.addRequestHeader("hello","world")).
                        uri("http://localhost:3333")).
                build();
    }
}
