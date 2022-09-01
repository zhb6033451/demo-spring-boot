package com.example.demo.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Person {
    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区
    private BigDecimal money;

    // 构造方法
    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public Person(String name, int salary, String sex, String area, BigDecimal money) {
        this.name = name;
        this.salary = salary;
        this.sex = sex;
        this.area = area;
        this.money = money;
    }
    // 省略了get和set，请自行添加

    public static List<Person> getPersonList() {
        List<Person> personList = new ArrayList<Person> ();
        personList.add (new Person ("Tom", 8900, "male", "New York", new BigDecimal ("333")));
        personList.add (new Person ("Tom", 8900, "male", "New York", new BigDecimal ("333")));
        personList.add (new Person ("Tom", 8900, "male", "New York", new BigDecimal ("333")));
        personList.add (new Person ("Jack", 7000, "male", "Washington", new BigDecimal ("123")));
        personList.add (new Person ("Lily", 7800, "female", "Washington", new BigDecimal ("222")));
        personList.add (new Person ("Lily", 7800, "female", "Washington", new BigDecimal ("222")));
        personList.add (new Person ("Lily", 7800, "female", "Washington", new BigDecimal ("222")));
        personList.add (new Person ("Anni", 8200, "female", "New York", new BigDecimal ("444")));
        personList.add (new Person ("Owen", 9500, "male", "New York", new BigDecimal ("555")));
        // personList.add (new Person ("Alisa", 7900, "female", "New York", new BigDecimal ("666")));
        return personList;
    }

}
