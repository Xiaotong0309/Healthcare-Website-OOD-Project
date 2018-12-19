package com.test.health.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.health.model.Bill;
import com.test.health.vo.BillVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface BillMapper extends BaseMapper<Bill> {

    /**
     * list add all bill of a patient
     * @param userId
     * @return
     */
    @Select("select b.status as status, b.amount as amount, app.doctor_name as doctorName, app.time as time, app.id as appointment_id" +
            " from bill b inner join appointment app on app.id = b.appointment_id where app.patient_id=#{userId} ")
    List<BillVO> listBill(@Param("userId")Long userId);
}
