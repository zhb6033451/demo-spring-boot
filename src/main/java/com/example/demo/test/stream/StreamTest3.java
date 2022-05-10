package com.example.demo.test.stream;

import com.example.demo.pojo.Person;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest3 {

    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Person> personList = Person.getPersonList ();
        //取出偶数
        List<Integer> collect = list.stream ().filter (x -> x % 2 == 0).collect (Collectors.toList ());
        //取出不重复的偶数
        Set<Integer> collect1 = list.stream ().filter (x -> x % 2 == 0).collect (Collectors.toSet ());
        //取出薪资大于8000的人
        Map<String, Person> collect2 = personList.stream ().filter (p -> p.getSalary () > 8000).
                collect (Collectors.toMap (Person::getName, Function.identity ()));
        System.out.println (collect);
        System.out.println (collect1);
        System.out.println (collect2);
    }

    @Test
    public void test2(){
        //统计员工人数、平均工资、工资总额、最高工资
        List<Person> personList = Person.getPersonList ();
        // 求总数
        Long collect = personList.stream ().collect (Collectors.counting ());
        // 求平均工资
        Double collect1 = personList.stream ().collect (Collectors.averagingDouble (Person::getSalary));
        // 求工资之和
        Integer collect2 = personList.stream ().collect (Collectors.summingInt (Person::getSalary));
        // 求最高工资
        Optional<Person> collect3 = personList.stream ().collect
                (Collectors.maxBy (Comparator.comparing (Person::getSalary)));
        // 一次性统计所有信息
		DoubleSummaryStatistics collect4 = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println (collect);
        System.out.println (collect1);
        System.out.println (collect2);
        System.out.println (collect3);
    }

    @Test
    public void test3(){
        List<Person> personList = Person.getPersonList ();
        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> collect = personList.stream ().collect
                (Collectors.groupingBy (p -> p.getSalary () > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> collect1 = personList.stream ().collect (Collectors.groupingBy (Person::getSex));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> collect2 = personList.stream ().collect
                (Collectors.groupingBy (Person::getSex, Collectors.groupingBy (Person::getArea)));
        System.out.println (collect);
        System.out.println (collect1);
        System.out.println (collect2);
    }

    @Test
    public void test4(){
        List<Person> personList = Person.getPersonList ();
        String collect = personList.stream ().map (Person::getName).collect (Collectors.joining (","));
        List<String> list = Arrays.asList("A", "B", "C");
        String collect1 = list.stream ().collect (Collectors.joining ("--"));
        System.out.println (collect);
        System.out.println (collect1);
    }

    @Test
    public void test5(){
        List<Person> personList = Person.getPersonList ();
        // 每个员工减去起征点后的薪资之和
        Integer collect = personList.stream ().collect (Collectors.reducing (0, Person::getSalary, (s1, s2) -> s1 + s2 - 5000));
        // stream的reduce
        Optional<Integer> integer = personList.stream ().map (Person::getSalary).reduce (Integer::sum);
        System.out.println (collect);
        System.out.println (integer);
    }

    @Test
    public void test6(){
        List<Person> personList = Person.getPersonList ();
        // 将员工按工资由高到低（工资一样则按年龄由大到小）排序
        // 按工资升序排序（自然排序）
        List<Person> collect = personList.stream ().sorted (Comparator.comparing (Person::getSalary)).collect (Collectors.toList ());
        // 按工资倒序排序
        List<Person> collect1 = personList.stream ().sorted ((p1, p2) -> p1.getSalary () < p2.getSalary () ? 1 : -1).collect (Collectors.toList ());
        List<Person> collect2 = personList.stream ().sorted (Comparator.comparing (Person::getSalary).reversed ()).collect (Collectors.toList ());
        // 先按工资再按年龄升序排序
        List<Person> collect3 = personList.stream ().sorted
                (Comparator.comparing (Person::getSalary).thenComparing (Person::getAge)).collect (Collectors.toList ());
        // 先按工资再按年龄自定义排序（降序）
        List<Person> collect4 = personList.stream ().sorted
                (Comparator.comparing (Person::getSalary).thenComparing (Person::getAge).reversed ()).collect (Collectors.toList ());
        List<Person> collect5 = personList.stream ().sorted ((p1, p2) -> {
            if (p1.getSalary () == p2.getSalary ()) {
                return p1.getAge () - p2.getAge ();
            } else {
                return p2.getSalary () - p1.getSalary ();
            }
        }).collect (Collectors.toList ());
        System.out.println (collect);
        System.out.println (collect1);
        System.out.println (collect2);
        // System.out.println (collect3);
        // System.out.println (collect4);
        // System.out.println (collect5);

    }

    @Test
    public void test7(){
        String[] arr1 = { "a", "b", "c", "d" };
		String[] arr2 = { "d", "e", "f", "g" };
        Stream<String> stream1 = Stream.of (arr1);
        Stream<String> stream2 = Stream.of (arr2);
        // concat:合并两个流 distinct：去重
        List<String> collect1 = Stream.concat (stream1, stream2).distinct ().collect (Collectors.toList ());
        // limit：限制从流中获得前n个数据
        List<Integer> collect2 = Stream.iterate (1, x -> x + 2).limit (10).collect (Collectors.toList ());
        // skip：跳过前n个数据
        List<Integer> collect3 = Stream.iterate (1, x -> x + 2).skip (2).limit (5).collect (Collectors.toList ());

        System.out.println (collect1);
        System.out.println (collect2);
        System.out.println (collect3);
    }

}
