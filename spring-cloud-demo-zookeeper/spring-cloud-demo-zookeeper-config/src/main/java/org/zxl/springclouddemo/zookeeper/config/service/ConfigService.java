package org.zxl.springclouddemo.zookeeper.config.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zxl.springclouddemo.zookeeper.config.prop.ZeekeeperProperties;

@Service
public class ConfigService {
    @Autowired
    private ZeekeeperProperties zeekeeperProperties;

    public String getAge(){
        return zeekeeperProperties.getAge();
    }
}
