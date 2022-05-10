package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.FinFeeDetail;


public interface FinfeeService extends IService<FinFeeDetail> {

    FinFeeDetail getFeeDetail(Integer id);

    void error1(Integer id);

}
