package com.example.demo.controller;

import com.example.demo.pojo.FinFeeDetail;
import com.example.demo.service.FinfeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;


@Slf4j
@RestController
@RequestMapping("/finfee")
public class FinfeeController {

    @Resource
    private FinfeeService finfeeService;


    @GetMapping("/getone/{id}")
    public String getFinfee(@PathVariable("id") Integer id){
        // FinFeeDetail finFeeDetail = finfeeService.getById (id);
        FinFeeDetail finFeeDetail = finfeeService.getFeeDetail (id);
        return "查询到:" + finFeeDetail.getItemName ();
    }


    @GetMapping("/test")
    public String getTest(){
        Random random = new Random ();
        int num = random.nextInt(100);
        return "test - "+ num;
    }

    @GetMapping("/update/{id}")
    @Transactional(rollbackFor = Exception.class)
    public void update(@PathVariable("id") Integer id) throws Exception{
        try{
            FinFeeDetail finFeeDetail = finfeeService.getById (id);
            System.out.println (finFeeDetail.getItemId ());
            finFeeDetail.setItemId (333);
            finfeeService.updateById (finFeeDetail);
            throw new Exception("error");
        }catch (Exception e){

        }
    }


    @GetMapping("/error/{id}")
    public String getError(@PathVariable("id") Integer id){
        finfeeService.error1 (id);
        return "error";
    }

    @GetMapping("/out/{id}")
    @Transactional
    public void out(@PathVariable("id") Integer id) throws Exception {
        this.inner (id);
        FinFeeDetail finFeeDetail = finfeeService.getById (id);
        System.out.println (finFeeDetail.getItemId ());
        finFeeDetail.setItemId (333);
        finfeeService.updateById (finFeeDetail);
        // throw new Exception ();
    }

    @Transactional(rollbackFor = Exception.class)
    public void inner(Integer id) throws Exception {
        FinFeeDetail finFeeDetail = finfeeService.getById (id);
        System.out.println (finFeeDetail.getItemId ());
        finFeeDetail.setItemId (333);
        finfeeService.updateById (finFeeDetail);
        throw new Exception();
    }

    @PostMapping("/jieya")
    public List getFeeDetails(@RequestBody String info){
        return finfeeService.getFeeList (info);
    }


}
