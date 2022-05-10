package com.example.demo.test.task;

public interface BaskTask extends Runnable {
    //获取执行频率
    String getCron();
    //执行任务逻辑
    void execute();
}
