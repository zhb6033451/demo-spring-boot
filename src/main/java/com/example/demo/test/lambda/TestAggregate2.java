package com.example.demo.test.lambda;

import com.example.demo.pojo.Hero;

import java.util.*;

public class TestAggregate2 {
    public static void main(String[] args) {

        Random r = new Random();
        List<Hero> heros = new ArrayList<> ();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("遍历集合中的每个数据");
        heros.stream ().forEach (h-> System.out.println (h));

        System.out.println("返回一个数组");
        Object[] array = heros.stream ().toArray ();
        System.out.println (Arrays.toString (array));

        System.out.println("返回伤害最低的那个英雄");
        Hero hero1 = heros.stream ().min (Comparator.comparingInt (h -> h.damage)).get ();
        System.out.println (hero1);

        System.out.println("返回伤害最高的那个英雄");
        Hero hero2 = heros.stream ().max (Comparator.comparingInt (h -> h.damage)).get ();
        System.out.println (hero2);

        System.out.println("流中数据的总数");
        long count = heros.stream ().count ();
        System.out.println (count);

        System.out.println("第一个英雄");
        Hero hero3 = heros.stream ().findFirst ().get ();
        System.out.println (hero3);

        System.out.println ("把hp第三高的英雄名称打印出来");
        Hero hero4 = heros.stream ().sorted ((h1, h2) -> h1.hp < h2.hp ? 1 : -1).skip (2).findFirst ().get ();
        System.out.println (hero4);
    }
}
