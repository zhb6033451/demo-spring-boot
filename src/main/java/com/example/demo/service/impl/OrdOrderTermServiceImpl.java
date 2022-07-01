package com.example.demo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.OrdOrderTermDao;
import com.example.demo.mapper.OrdOrderTermMapper;
import com.example.demo.pojo.OrdOrderTerm;
import com.example.demo.service.OrdOrderTermService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by helei3669 on 2021-05-26 16:06.
 */
@Service
public class OrdOrderTermServiceImpl extends ServiceImpl<OrdOrderTermMapper,OrdOrderTerm> implements OrdOrderTermService {

    @Resource
    OrdOrderTermMapper ordOrderTermMapper;

    @Resource
    OrdOrderTermDao ordOrderTermDao;

    @Override
    public int updateNotNullFieldById(OrdOrderTerm dto) {
        return ordOrderTermDao._updateNotNullFieldById(dto, dto.getId());
    }

}
