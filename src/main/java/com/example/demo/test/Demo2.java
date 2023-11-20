package com.example.demo.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

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

    @Test
    public void test02() {
        // 正则表达式 用于匹配手机号
        String regExp = "^1[3|4|5|7|8][0-9]{9}$";
        // 要验证的字符串
        String str = "12345678901";
        // 编译正则表达式
        Pattern pattern = Pattern.compile (regExp);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
        // 正则表达式的匹配器
        boolean matches = pattern.matcher (str).matches ();
        // 字符串是否与正则表达式相匹配
        System.out.println (matches);
    }

}
