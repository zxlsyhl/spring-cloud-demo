package org.zxl.springclouddemo.nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
    @Value("${maxId}")
    private String maxId;

    @Value("${bigId:111}")
    private String bigId;

    @GetMapping("/getTheMaxId")
    public String getTheMaxId(){
        return maxId;
    }

    @GetMapping("/getTheBigId")
    public String getTheBigId(){
        return bigId;
    }
}
