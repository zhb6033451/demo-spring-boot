package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.FinFeeDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FinfeeMapper extends BaseMapper<FinFeeDetail> {

    FinFeeDetail getFeeDetail(@Param("id") Integer id);


}
