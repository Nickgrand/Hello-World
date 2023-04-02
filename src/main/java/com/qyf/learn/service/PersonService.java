package com.qyf.learn.service;

import com.qyf.learn.mapper.PersonMapper;
import com.qyf.learn.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: HuiMing
 * @Date: Created in 2023/4/2 19:51
 * @ModifiedBy:
 */
@Service
public class PersonService {
    @Autowired
    PersonMapper personMapper;

    public Person getPerson(Integer id) {
        return personMapper.findById(id);
    }
}
