package com.test.health.dao.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.test.health.model.Session;
import org.apache.ibatis.annotations.Select;

public interface SessionMapper extends BaseMapper<Session> {

    @Select("select * from session")
    Page<Session> listSession();
}
