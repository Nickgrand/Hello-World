package com.qyf.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: HuiMing
 * @Date: Created in 2023/4/2 19:17
 * @ModifiedBy:
 */
@RestController
public class PropertiesController {

    static String producerNameSrvAddr;
    @Value("${producer.group}")
    String producerGroup;
    @Value("${producer.instanceName}")
    String producerInstanceName;

    @GetMapping("/getProducer")
    public String getProducer() {
        String template = "生产者信息: "
                + "{group=" + this.producerGroup
                + ", instance name=" + this.producerInstanceName + "}, ";
        String staticThings = "{static nameserver address=" + producerNameSrvAddr + "}";
        return template + staticThings;
    }

    @Value("${producer.nameSrvAddr}")
    public void setProducerNameSrvAddr(String producerNameSrvAddr) {
        PropertiesController.producerNameSrvAddr = producerNameSrvAddr;
    }
}
