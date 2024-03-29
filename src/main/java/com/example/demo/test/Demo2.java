package com.example.demo.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.DetailTableInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Map;
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

    @Test
    public void test03(){
        // 读取文件json.txt,获取里面内容
        String path = "json.txt";
        // 读取文件内容
        String content = FileUtil.readUtf8String (path);
        System.out.println (content);
        // 转成List<DetailTableInfo> detailTableInfos
        List<DetailTableInfo> detailTableInfos = JSON.parseArray (content, DetailTableInfo.class);
        // 转换为json字符串
        System.out.println (JSON.toJSONString (detailTableInfos));
        if (CollectionUtils.isNotEmpty (detailTableInfos)) {
            DetailTableInfo detailTableInfo1 = detailTableInfos.get (1);
            List<Object> dtnum1 = detailTableInfo1.getDtnum1 ();
            // 添加新字段
            Map<String, Object> o = (Map<String, Object>) dtnum1.get (0);
            o.put ("SKRYHKZP", "1");
            o.put ("SKRZJZ", "2");
        }
        System.out.println (JSON.toJSONString (detailTableInfos));
    }

    @Test
    public void test04(){
        // date转成yy-MM-dd的字符串
        Date date = new Date ();
        String format = DateUtil.format (date, "yy-MM-dd");
        System.out.println (format);
    }
}
