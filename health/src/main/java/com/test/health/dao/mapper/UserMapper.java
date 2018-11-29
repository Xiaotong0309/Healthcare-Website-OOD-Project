package com.test.health.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.health.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper extends BaseMapper<User> {
    /**
     * find user by username and password, for user login
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where name=#{name} and password=#{password}")
    User selectBy(@Param("name") String username, @Param("password") String password);
}
