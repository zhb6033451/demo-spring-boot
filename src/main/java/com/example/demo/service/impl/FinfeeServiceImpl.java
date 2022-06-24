package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.FinfeeMapper;
import com.example.demo.pojo.FinFeeDetail;
import com.example.demo.service.FinfeeService;
import com.example.demo.service.FinfeeService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Slf4j
@Service
public class FinfeeServiceImpl extends ServiceImpl<FinfeeMapper, FinFeeDetail> implements FinfeeService {

    @Resource
    private FinfeeMapper finfeeMapper;

    @Resource
    private FinfeeService2 finfeeService2;

    @Override
    public FinFeeDetail getFeeDetail(Integer id) {
        return finfeeMapper.getFeeDetail (id);
    }

    @Override
    @Transactional( rollbackFor = Throwable.class)
    public void error1(Integer id) {
        // finfeeService2.error2 (id);
        this.updateFee (id);
        // throw new RuntimeException("error1");
    }

    public void updateFee(Integer id){
        FinFeeDetail finFeeDetail = baseMapper.selectById (id);
        System.out.println (finFeeDetail.getItemId ());
        finFeeDetail.setItemId (1111);
        baseMapper.updateById (finFeeDetail);
        System.out.println ("updateFee");
    }
}
