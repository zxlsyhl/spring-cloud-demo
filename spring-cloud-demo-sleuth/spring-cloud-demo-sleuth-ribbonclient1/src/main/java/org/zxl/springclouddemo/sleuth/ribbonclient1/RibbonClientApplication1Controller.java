package org.zxl.springclouddemo.sleuth.ribbonclient1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonClientApplication1Controller {
    private Logger logger = LoggerFactory.getLogger(RibbonClientApplication1Controller.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ribbon-client-1")
    public String test() {
        logger.info("RibbonClient1Controller--test() is requesting....");
        return restTemplate.getForObject("http://ribbon-client2/callRabbitClient2", String.class);
    }

    @RequestMapping("/test2")
    public String test2() {
        logger.info("RibbonClient1Controller--test2() is requesting....");
        restTemplate.getForObject("http://ribbon-client2/callRabbitClient2", String.class);
        return restTemplate.getForObject("http://ribbon-client2/test2", String.class);
    }

    @RequestMapping("/callRabbitClient1")
    public String callRabbitClient1() {
        logger.info("RibbonClient1Controller--callRabbitClient1 is requesting...");
        return "hello ,Spring Cloud Sleuth!";
    }

    @RequestMapping("/test3")
    public String test3() {
        logger.info("RibbonClient1Controller--test3() is requesting....");
        return restTemplate.getForObject("http://ribbon-client2/test3", String.class);
    }
}
