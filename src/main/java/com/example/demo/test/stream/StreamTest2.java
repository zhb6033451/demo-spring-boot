package com.example.demo.test.stream;

import com.example.demo.pojo.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {

    @Test
    public void test1(){
        // 英文字符串数组的元素全部改为大写。整数数组每个元素+3。
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> collect = Arrays.stream (strArr).map (x -> x.toUpperCase ()).collect (Collectors.toList ());
        System.out.println (collect);
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> collect1 = intList.stream ().map (x -> x + 3).collect (Collectors.toList ());
        System.out.println (collect1);
    }

    @Test
    public void test2(){
        // 将员工的薪资全部增加1000。
        List<Person> personList = Person.getPersonList ();
        List<Person> collect = personList.stream ().map (x -> {
            Person person = new Person (x.getName (),x.getSalary () + 1000,x.getAge (),x.getSex (),x.getArea ());
            return person;
        }).collect (Collectors.toList ());
        System.out.println (collect);
    }

    @Test
    public void test3(){
        //将两个字符数组合并成一个新的字符数组。
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> collect = list.stream ().flatMap (x -> {
            String[] split = x.split (",");
            Stream<String> stream = Arrays.stream (split);
            return stream;
        }).collect (Collectors.toList ());
        System.out.println (list);
        System.out.println (collect);
    }

    @Test
    public void test4(){
        //求Integer集合的元素之和、乘积和最大值。
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
		// 求和方式1
        Integer integer = list.stream ().reduce (0, Integer::sum);
        // 求和方式2
        Integer integer1 = list.stream ().reduce (Integer::sum).get ();
        // 求和方式3
        Integer integer2 = list.stream ().reduce ((x1, x2) -> x1 + x2).get ();

        // 求乘积
        Integer integer3 = list.stream ().reduce ((x1, x2) -> x1 * x2).get ();

        // 求最大值方式1
        Integer integer4 = list.stream ().reduce ((x1, x2) -> x1 > x2 ? x1 : x2).get ();
        // 求最大值写法2
        Integer integer5 = list.stream ().reduce (Integer::max).get ();

        System.out.println (integer);
        System.out.println (integer1);
        System.out.println (integer2);
        System.out.println (integer3);
        System.out.println (integer4);
        System.out.println (integer5);
    }

    @Test
    public void test5(){
        //求所有员工的工资之和和最高工资。
        List<Person> personList = Person.getPersonList ();
        // 求工资之和方式1：
        Integer integer = personList.stream ().map (Person::getSalary).reduce (Integer::sum).get ();

        // 求工资之和方式2：
        Integer integer1 = personList.stream ().map (p -> p.getSalary ()).reduce ((s1, s2) -> s1 + s2).get ();
        // 求工资之和方式3：
        Integer sumSalary2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(),
				(sum1, sum2) -> sum1 + sum2);

		// 求最高工资方式1：
        Integer integer2 = personList.stream ().map (Person::getSalary).reduce (Integer::max).get ();
        // 求最高工资方式2：
        Integer integer3 = personList.stream ().map (Person::getSalary).reduce ((s1, s2) -> s1 > s2 ? s1 : s2).get ();

        System.out.println (integer);
        System.out.println (integer1);
        System.out.println (sumSalary2);
        System.out.println (integer2);
        System.out.println (integer3);
    }
}
