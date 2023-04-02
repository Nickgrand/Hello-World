package com.qyf.learn.controller;

import com.qyf.learn.pojo.Person;
import org.springframework.web.bind.annotation.*;

/**
 * @author: HuiMing
 * @Date: Created in 2023/4/1 23:34
 * @ModifiedBy:
 */
@RestController
public class ParamController {
    private static String SOMETHING = "Hello, this is a interface";

    @GetMapping("/getSomething")
    public String getSomething() {
        return SOMETHING;
    }

    @GetMapping("/request_num")
    public String getRequest(@RequestParam Integer num) {
        String template = "拿到了get参数";
        num = num + 1;
        return template + num;
    }

    @PostMapping("/post_person")
    public String postRequest(@RequestBody Person person) {
        String template = "收到了post参数";
        return template + "\n" + person;
    }
}
