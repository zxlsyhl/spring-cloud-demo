package org.zxl.springclouddemo.consul.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
    @Value("${maxId}")
    private String maxId;

    @GetMapping("/getTheMaxId")
    public String getTheMaxId(){
        return maxId;
    }

    @GetMapping("/hello")
    public String hello(){
        return "helle consul config";
    }

}
