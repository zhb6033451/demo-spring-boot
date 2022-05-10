package com.example.demo.test.lambda;

import com.example.demo.pojo.Hero;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestAggregate3 {
    public static void main(String[] args) {
        //一个长度为n的字符串数组，取出现频率最多的k单词，
        String[] words = new String[]{"adsad","ywewq","dasda","dasda"};
        // List<String> collect =
        System.out.println (
                Arrays.stream (words)
                .collect (Collectors.groupingBy (Function.identity ()))
                /*.entrySet ()
                .stream ()
                .sorted ((o1, o2) -> {
                    if (o1.getValue ().equals (o2.getValue ())) {
                        return o1.getKey ().compareTo (o2.getKey ());
                    } else {
                        return o2.getKey ().compareTo (o1.getKey ());
                    }
                })
                .map (Map.Entry::getKey)
                .limit (10)
                .collect (Collectors.toList ())*/
                );
        // System.out.println (collect);
    }

    @Test
    public void test() {
        List<Hero> personList = new ArrayList<> ();
        personList.add(new Hero("hepengju", 28, 20000));
        personList.add(new Hero("lisi"    , 44, 40000));
        personList.add(new Hero("wangwu"  , 55, 50000));
        personList.add(new Hero("zhaoliu" , 66, 60000));
        personList.add(new Hero("zhangsan", 33, 33333));
        personList.add(new Hero("wgr", 23, 10000));
        System.out.println ();
        Map<Hero, List<Hero>> collect = personList.stream ().collect (Collectors.groupingBy (Function.identity ()));
        collect.forEach((name,p) ->{
            System.out.println(name + ":"+p);
        });
        // System.out.println (collect);

    }
}
