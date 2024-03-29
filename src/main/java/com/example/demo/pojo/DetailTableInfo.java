package com.example.demo.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Author bulingfeng
 * @Date 2023/02/13
 * @Description 退费退学使用的实体类
 * 该结构是由OA指定的，学生系统来配合这个结构
 * 改结构报文如下
 * "detailTableInfo": [
 *     {
 *       "dtnum": "1",
 *       "dtnum1": [
 *         {
 *           "XSXX": "张三",
 *           "SFZH": "330681199812121234",
 *           "SKRXM": "张三父亲",
 *           "SKRKHH": "102126205149",
 *           "SKRKH": "6222120212341222",
 *           "TFJE": "1000.00"
 *         },
 *         {
 *           "XSXX": "李四",
 *           "SFZH": "330681199812121234",
 *           "SKRXM": "李四父亲",
 *           "SKRKHH": "102126205149",
 *           "SKRKH": "6222120212341222",
 *           "TFJE": "2000.00"
 *         }
 *       ]
 *     },
 *     {
 *       "dtnum": "2",
 *       "dtnum2": [
 *         {
 *           "YJSFX": "学杂费",
 *           "EJSFX": "班会费",
 *           "ZXFWSM": "退回班会费"
 *         },
 *         {
 *           "YJSFX": "学杂费",
 *           "EJSFX": "春游费",
 *           "ZXFWSM": "退回春游费"
 *         }
 *       ]
 *     }
 *   ]
 */
@Data
public class DetailTableInfo {

    @JSONField(name = "dtnum")
    private String dtnum;


    @JSONField(name = "dtnum1")
    private List<Object> dtnum1;



    @JSONField(name = "dtnum2")
    private List<Object> dtnum2;

}
