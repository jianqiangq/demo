package com.qjq.demo.mapper;

import com.qjq.demo.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USER (name, account_id, token, gmt_create, gmt_modified) VALUES (#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModified})")
    // User user 中的 name 会自动填充到上面 sql 语句中的 #{name} 中替换
    void insert(User user); // 参数为类，会自动给把类的成员变量赋值给上面注解的 sql 语句

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token); // 参数不为类，需要加上 @Param 的注解，才能把参数赋值给上面注解的 sql 语句
}
