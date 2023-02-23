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

    public Person(){

    }

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
        personList.add (new Person ("Tom", 6000, "male", "New York", new BigDecimal ("333")));
        personList.add (new Person ("Ato", 7800, "male", "New York", new BigDecimal ("333")));
        personList.add (new Person ("Kal", 5600, "male", "New York", new BigDecimal ("333")));
        personList.add (new Person ("Jack", 7000, "male", "Washington", new BigDecimal ("123")));
        personList.add (new Person ("Jiy", 6200, "female", "Washington", new BigDecimal ("222")));
        personList.add (new Person ("Ter", 9100, "female", "China", new BigDecimal ("222")));
        personList.add (new Person ("Lily", 8300, "female", "Washington", new BigDecimal ("222")));
        personList.add (new Person ("Cdf", 8200, "female", "California", new BigDecimal ("444")));
        personList.add (new Person ("Anni", 8400, "female", "California", new BigDecimal ("444")));
        personList.add (new Person ("Owen", 9500, "male", "California", new BigDecimal ("555")));
        personList.add (new Person ("Alisa", 7900, "female", "China", new BigDecimal ("666")));
        return personList;
    }

}
