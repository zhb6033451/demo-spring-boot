package com.example.demo.pojo;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class OaJsonResponse {
    private int errcode;
    private long requestId;
    private String errmsg;

    // getter和setter方法
    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    // toString方法，用于打印对象信息
    @Override
    public String toString() {
        return "OaJsonResponse{" +
                "errcode=" + errcode +
                ", requestId=" + requestId +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    // 静态方法，用于解析JSON字符串并返回对象
    public static OaJsonResponse parseJson(String json) {
        OaJsonResponse response = new OaJsonResponse ();
        Map<String, Object> map = new HashMap<>();

        // 这里假设使用org.json库来解析JSON字符串
        // 首先将JSON字符串转换成Map
        JSONObject jsonObject = JSONObject.parseObject(json);

        map.put("errcode", jsonObject.getIntValue ("errcode"));
        map.put("requestId", jsonObject.getLong("requestId"));
        map.put("errmsg", jsonObject.getString("errmsg"));

        // 将Map中的值赋给对象的属性
        response.setErrcode((int) map.get("errcode"));
        response.setRequestId((long) map.get("requestId"));
        response.setErrmsg((String) map.get("errmsg"));

        return response;
    }
}