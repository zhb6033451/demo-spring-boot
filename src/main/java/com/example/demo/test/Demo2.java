package com.example.demo.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo2 {

    @Test
    public void test01(){
        String url = "http://10.30.5.29/scrm-h5";
        // 随机生成字符串
        String noncestr = RandomUtil.randomString (10);
        System.out.println ("随机生成字符串:  "+noncestr);
        String jsapiTicket = "LIKLckvwlJT9cWIhEQTwfAF-4COnGCPpAYpkTozbwW3wBRG6-v-mT-7v-z4H6KSWrnO28ymmePLV5FHQqb-raQ";
        // 时间戳
        long timestamp = DateUtil.currentSeconds();
        System.out.println ("时间戳:  "+timestamp);
        String string = "jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s";
        String format = String.format (string, jsapiTicket, noncestr, timestamp, url);
        System.out.println ("拼接的字符串:  "+format);
        String sha1Hex = DigestUtil.sha1Hex (format);
        System.out.println ("sha1加密后字符串:  "+sha1Hex);
    }
}
