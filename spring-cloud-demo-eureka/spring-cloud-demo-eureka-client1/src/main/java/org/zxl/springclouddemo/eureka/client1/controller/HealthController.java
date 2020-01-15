package org.zxl.springclouddemo.eureka.client1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 健康检查服务
 */
@RestController
public class HealthController {
    @GetMapping("/heath")
    @ResponseBody
    public String heath()
    {
        return "ok";
    }
}
