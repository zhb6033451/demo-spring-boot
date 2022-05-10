package com.example.demo.test.stream;

import com.example.demo.pojo.Person;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {

    }

    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件>6的元素
        list.stream ().filter (x -> x>6).forEach (System.out::println);
        // 匹配第一个
        Integer integer = list.stream ().findFirst ().get ();
        // 匹配任意（适用于并行流）
        Integer integer1 = list.parallelStream ().findAny ().get ();
        // 是否包含符合特定条件的元素
        boolean b = list.stream ().anyMatch (x -> x > 6);
        System.out.println (integer);
        System.out.println (integer1);
        System.out.println (b);
    }

    @Test
    public void test2(){
        //筛选员工中工资高于8000的人，并形成新的集合。 形成新集合依赖collect（收集）。
        List<Person> personList = Person.getPersonList ();
        List<String> collect = personList.stream ().filter (n -> n.getSalary () > 8000).
                map (Person::getName).collect (Collectors.toList ());
        System.out.println (collect);
    }

    @Test
    public void test3(){
        // 获取String集合中最长的元素。
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        String s = list.stream ().max (Comparator.comparingInt (String::length)).get ();
        System.out.println (s);
    }

    @Test
    public void test4(){
        // 获取Integer集合中的最大值。
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
        Integer integer = list.stream ().max (Comparator.comparing (Integer::intValue)).get ();
        System.out.println (integer);
    }

    @Test
    public void test5(){
        // 获取员工工资最高的人。
        List<Person> personList = Person.getPersonList ();
        Person person = personList.stream ().max (Comparator.comparingInt (Person::getSalary)).get ();
        System.out.println (person);
    }

    @Test
    public void test(){
        // 计算Integer集合中大于6的元素的个数。
        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        long count = list.stream ().filter (x -> x > 6).count ();
        System.out.println (count);
        System.out.println (LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }


}
