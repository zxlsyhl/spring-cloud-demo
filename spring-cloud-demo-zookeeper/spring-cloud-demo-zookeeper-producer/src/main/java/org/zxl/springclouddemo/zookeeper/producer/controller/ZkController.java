package org.zxl.springclouddemo.zookeeper.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZkController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Environment environment;

    @GetMapping("/getServices")
    public String discoveryClent() {
        List<String> serviceList = discoveryClient.getServices();
        System.out.println("注册服务的数量>>>>>>>>>>>>>>>>>" + serviceList.size());
        for (String service : serviceList) {
            System.out.println("注册的服务>>>>>>" + service);
        }
        return "info";
    }

    @GetMapping("/env")
    public String test() {
        String[] profiles = environment.getActiveProfiles();
        System.out.println("profiles>>>>>>>" + profiles.length);
        for (String item : profiles) {
            System.out.println("item>>>>>>>>>>>>>>>" + item);
        }

        String name = environment.getProperty("url");
        System.out.println(name);

        return "Hello," + name;
    }
}
