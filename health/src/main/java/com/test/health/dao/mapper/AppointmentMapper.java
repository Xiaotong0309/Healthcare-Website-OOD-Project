package com.test.health.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.health.model.Appointment;
import com.test.health.model.Session;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;


public interface AppointmentMapper extends BaseMapper<Appointment> {

    /**
     * list all available appointment
     * @param name
     * @param start
     * @param endDate
     * @return
     */
    @Select("<script> " +
            "select * from appointment  " +
            "<where> status=0" +
//            <if test = 'userId != null'> and user_id = #{userId}</if>
            "<if test = 'name != null'> and doctor_name like CONCAT('%',#{name},'%') </if> " +
            "<if test='start!=null'> and time >= #{start}</if> " +
            "<if test='endDate!=null'> and time <![CDATA[ <= ]]>#{endDate}</if> " +
//            "<if test = 'endDate!=null'> and time < #{endDate}</if> " +
            "</where> " +
            "</script> ")
    List<Appointment> listAvailableApp(@Param("name")String name, @Param("start")Date start, @Param("endDate")Date endDate);


    /**
     * list all appointment of a doctor
     * @param doctor doctor id
     * @return
     */
    @Select("select * from appointment where status=1 and doctor_id=#{doctorId}")
    List<Appointment> selectDocAppList(@Param("doctorId")Long doctor);
}
