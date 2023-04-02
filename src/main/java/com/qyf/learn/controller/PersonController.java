package com.qyf.learn.controller;

import com.qyf.learn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: HuiMing
 * @Date: Created in 2023/4/2 19:53
 * @ModifiedBy:
 */
@RestController
public class PersonController {
    /**
     * 不推荐使用Autowired，因此使用如下方法
     */
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public String getPersonThings(@RequestParam Integer id) {
        return personService.getPerson(id).toString();
    }
}
