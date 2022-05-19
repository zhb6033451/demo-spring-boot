package com.example.demo.test.thread;

import com.example.demo.pojo.Hero;


public class TestThread {
    public static void main(String[] args) {

        Hero gareen = new Hero ();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero ();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero ();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero ();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        /*//盖伦攻击提莫
        while (!teemo.isDead ()) {
            gareen.attackHero (teemo);
        }

        //赏金猎人攻击盲僧
        while (!leesin.isDead ()) {
            bh.attackHero (leesin);
        }*/

        /*KillThread killThread1 = new KillThread(gareen,teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh,leesin);
        killThread2.start();*/

        /*Battle battle1 = new Battle (gareen, teemo);

        new Thread (battle1).start ();

        Battle battle2 = new Battle (bh, leesin);
        new Thread (battle2).start ();*/

        //匿名类
        /*Thread t1 = new Thread (() -> {
            //匿名类中用到外部的局部变量teemo，必须把teemo声明为final
            //但是在JDK7以后，就不是必须加final的了
            while (!teemo.isDead ()) {
                gareen.attackHero (teemo);
            }
        });

        t1.start ();

        Thread t2 = new Thread (() -> {
            while (!leesin.isDead ()) {
                bh.attackHero (leesin);
            }
        });
        t2.start ();*/

        /*Thread t1= new Thread (() -> {
            int seconds =0;
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.printf("已经玩了LOL %d 秒%n", seconds++);
            }
        });
        t1.start();*/

        Thread t1 = new Thread (() -> {
            while (!teemo.isDead ()) {
                gareen.attackHero (teemo);
            }
        });

        t1.start ();

        //代码执行到这里，一直是main线程在运行
        try {
            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
            t1.join ();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace ();
        }

        Thread t2 = new Thread (() -> {
            while (!leesin.isDead ()) {
                bh.attackHero (leesin);
            }
        });
        //会观察到盖伦把提莫杀掉后，才运行t2线程
        t2.start ();

    }

}
