package com.qyf.learn.mapper;

import com.qyf.learn.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: HuiMing
 * @Date: Created in 2023/4/2 19:47
 * @ModifiedBy:
 */
@Mapper
@Repository
public interface PersonMapper {
    /**
     * 根据id查找人员配置
     * @param id 人员id，主键
     * @return 返回人员配置
     */
    @Select("select * from person where id = #{id}")
    Person findById(Integer id);
}
