package org.zxl.springclouddemo.zookeeper.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zxl.springclouddemo.zookeeper.config.service.ConfigService;

@RestController
@RefreshScope
public class ConfigController {
    @Value("${maxId:100}")
    private String maxId;

    @GetMapping("/getTheMaxId")
    public String getTheMaxId(){
        return maxId;
    }

    @Autowired
    private ConfigService configService;

    @GetMapping("/getAge")
    public String getAge(){
        return configService.getAge();
    }
}
