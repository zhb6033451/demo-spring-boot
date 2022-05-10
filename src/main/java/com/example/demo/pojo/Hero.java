package com.example.demo.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Hero implements Comparable<Hero>{
    public String name;
    public float hp;

    public int damage;

    public Hero(){
    }

    public Hero(String name) {
        this.name =name;

    }

    //初始化name,hp,damage的构造方法
    public Hero(String name,float hp, int damage) {
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }



    public List<Hero> getHeros(){
        Random r = new Random ();
        List<Hero> list = new ArrayList<> ();
        for (int i = 0; i < 5; i++) {
            Hero hero = new Hero ("hero  "+i,r.nextInt (200),r.nextInt (100));
            list.add (hero);
        }
        return list;
    }

    @Override
    public int compareTo(Hero anotherHero) {
        if(damage<anotherHero.damage)
            return 1;
        else
            return -1;
    }

    public boolean matched(){
       return this.hp>100 && this.damage<50;
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }

}
