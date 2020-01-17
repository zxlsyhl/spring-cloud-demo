package org.zxl.springclouddemo.zookeeper.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperProducerApplication.class, args);

    }
}
