package com.example.demo.controller;

import com.example.demo.pojo.OrdOrderTerm;
import com.example.demo.service.OrdOrderTermService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/ordTerm")
public class OrdOrderTermController {

    @Resource
    private OrdOrderTermService ordOrderTermService;

    @GetMapping("/get/{id}")
    public Boolean getOrderTerm(@PathVariable("id") Integer id){
        OrdOrderTerm byId = ordOrderTermService.getById (id);
        return byId.getIsDeleted ();
    }

    @GetMapping("/insert")
    public String insert(){
        OrdOrderTerm ordOrderTerm = new OrdOrderTerm();
        ordOrderTerm.setOrderType ("66");
        // ordOrderTerm.setIsDeleted (false);
        boolean save = ordOrderTermService.save (ordOrderTerm);
        return save+"";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id) {
        OrdOrderTerm byId = ordOrderTermService.getById (id);
        byId.setOrderNo ("444");
        byId.setIsDeleted (null);
        boolean b = ordOrderTermService.updateById (byId);
        return b + "";
    }
}
