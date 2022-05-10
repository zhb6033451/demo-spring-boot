package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.FinfeeMapper;
import com.example.demo.pojo.FinFeeDetail;
import com.example.demo.service.FinfeeService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class FinfeeService2Impl extends ServiceImpl<FinfeeMapper, FinFeeDetail> implements FinfeeService2 {

    @Override
    @Transactional
    public void error2(Integer id) {
        FinFeeDetail finFeeDetail = baseMapper.selectById (id);
        System.out.println (finFeeDetail.getItemId ());
        finFeeDetail.setItemId (1111);
        baseMapper.updateById (finFeeDetail);
        throw new RuntimeException("error2");
    }
}
