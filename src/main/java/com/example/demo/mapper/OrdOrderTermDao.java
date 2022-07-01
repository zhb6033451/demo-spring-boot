package com.example.demo.mapper;

import com.example.demo.pojo.OrdOrderTerm;
import com.hailiang.orm.mybatis.plugin.api.annotation.MapperInfo;
import com.hailiang.orm.mybatis.plugin.mapper.SimpleMapper;

/**
 * Created by helei3669 on 2021-05-26 15:36.
 */

@MapperInfo(entity = OrdOrderTerm.class)
public interface OrdOrderTermDao extends SimpleMapper<OrdOrderTerm, Integer>  {

    /**
     * 根据学期订单查订单信息
     * @param termOrderNo
     * @return
     */
    OrdOrderTerm queryByTermOrderNo(String termOrderNo);

}
