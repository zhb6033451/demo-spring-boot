package com.example.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.OrdOrderTerm;

/**
 * Created by helei3669 on 2021-05-26 16:06.
 */
public interface OrdOrderTermService extends IService<OrdOrderTerm> {

    int updateNotNullFieldById(OrdOrderTerm model);

}
