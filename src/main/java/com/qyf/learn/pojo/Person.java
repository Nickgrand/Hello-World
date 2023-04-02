package com.qyf.learn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: HuiMing
 * @Date: Created in 2023/4/2 0:01
 * @ModifiedBy:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    Integer id;
    String name;
    @Override
    public String toString() {
        String content = "Person{" + "id=" + id + ", name=" + name + "}";
        return content + "\n";
    }
}
