package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.OrdOrderTerm;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrdOrderTermMapper extends BaseMapper<OrdOrderTerm> {

    OrdOrderTerm queryByTermOrderNo(String termOrderNo);

}
