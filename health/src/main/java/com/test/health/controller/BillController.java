package com.test.health.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.health.dao.mapper.BillMapper;
import com.test.health.info.UserInfo;
import com.test.health.model.Bill;
import com.test.health.model.User;
import com.test.health.vo.BillVO;
import com.test.health.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class BillController {

    @Resource
    private BillMapper billMapper;

    /**
     * add a bill by admin to the appointment
     * @param amount the amount to pay
     * @param appId the id of appointment
     * @return
     */
    @GetMapping("/api/bill/add")
    public Result addBill(@RequestParam Double amount, @RequestParam Long appId){

        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setAppointmentId(appId);
        billMapper.insert(bill);
        return Result.success();
    }

    /**
     * list all bills by the login patient
     * @return
     */
    @GetMapping("/api/bill/list")
    public Result listBill(){
        User user = UserInfo.get();
        List<BillVO> billVOList = billMapper.listBill(user.getId());
        return Result.success(billVOList);
    }


    /**
     * pay the bill of appointment by the login patient
     * @param appId id of the appointment
     * @param price the price of the bill
     * @return
     */
    @GetMapping("/api/bill/pay")
    public Result payBill(@RequestParam Long appId, @RequestParam Double price){
        Bill bill = billMapper.selectOne(new QueryWrapper<Bill>().eq("appointment_id",appId));
        bill.setPrice(price);
        bill.setStatus(1);
        billMapper.updateById(bill);
        return Result.success();
    }

}
