package com.example.demo.test.transaction;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ErrorDemo1 {

    int num = 0;

    @Test
    @Transactional( rollbackFor = Throwable.class)
    public void test18(){
        error2 ();
        System.out.println ("num:"+num);
        // int i = 1/0;
        // e.printStackTrace ();
        System.out.println ("catch");
        System.out.println ("num3:"+num);
        System.out.println ("end");
    }

    public void error2() {
        System.out.println ("error2");
        num++;
        System.out.println ("num2:"+num);
        error1 ();
    }

    public void error1 () {
        System.out.println ("error");
        num++;
        System.out.println ("num1:"+num);
        throw new RuntimeException("123");
    }
}
