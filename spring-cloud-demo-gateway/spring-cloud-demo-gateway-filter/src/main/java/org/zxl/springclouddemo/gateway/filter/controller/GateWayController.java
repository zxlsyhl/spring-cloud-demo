package org.zxl.springclouddemo.gateway.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateWayController {

    @GetMapping("/fallback")
    public String fallback(){
        return "fallback";
    }
}
