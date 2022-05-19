package com.example.demo.test;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Person;
import com.example.demo.pojo.Pojo;
import com.example.demo.utils.BenUtil;
import com.example.demo.utils.CollectorsUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class Demo1 {

    public static void main(String[] args) {
        String s = "9, 10, 11, 12, 1, 2, 3, 4, 5, 6";
        String[] split = s.split (",");
        List list = new ArrayList();
        for (String s1 : split) {list.add (Integer.valueOf(s1.trim ()));}
        System.out.println (list);
    }

    public static void test1(){
        int ts = 100;
        System.out.println (1%100);
        System.out.println (101%100);
        System.out.println (200%100);
        System.out.println (163456%100);
        System.out.println (new Double (Math.ceil(163456/100.0)).intValue ());
    }

    public static void test2(){
        JSONArray jsonArray = new JSONArray ();
        jsonArray.add (128);
        jsonArray.add (2);
        System.out.println (jsonArray);
        System.out.println (jsonArray.toString ());
    }

    public static void test3(){
        LocalDate localDate = LocalDate.parse ("2014-12-01");
        LocalDate yesterday = localDate.now().minusDays (1);
        // System.out.println (localDate.toString ());
        // System.out.println (localDate.plusDays (1));
        // System.out.println (localDate.plusDays (1+6));
        // System.out.println (localDate.isEqual (yesterday));
        int count = 0;
        int num = 1;
        System.out.println (count+=6);
        while (true){
            if (localDate.plusDays (count+6).isAfter (yesterday)){
                break;
            }
            System.out.println ("--------------第"+num+"次循环--------------");
            System.out.println (localDate.plusDays (count).toString ());
            System.out.println (localDate.plusDays (count+6).toString ());
            System.out.println ("--------------------------------------");
            count +=6;
            num ++;
        }
    }

    @Test
    public  void test4(){
        Integer a = 100;
        BigDecimal b = new BigDecimal("0.06");
        BigDecimal multiply = b.multiply (new BigDecimal (String.valueOf ( (double)2 / 24  )));
        System.out.println (multiply);
        multiply = multiply.setScale(2,BigDecimal.ROUND_HALF_UP);
        // 不足两位小数补0
        DecimalFormat decimalFormat = new DecimalFormat("0.00#");
        decimalFormat.format(multiply);
        System.out.println (multiply);
    }

    @Test
    public void test4_1(){
        BigDecimal a = new BigDecimal("0.01");
        BigDecimal c1 = new BigDecimal("0.02");
        BigDecimal c2 = new BigDecimal("-100");
        System.out.println (a.negate());
        System.out.println (c2.negate());
    }

    @Test
    public void test4_2(){
        BigDecimal a = new BigDecimal("0.01");
        BigDecimal multiply = a.multiply (new BigDecimal (String.valueOf (5)).divide (new BigDecimal ("100"),2,BigDecimal.ROUND_HALF_UP));
        System.out.println (multiply);
    }

    public static void test5(){
        String DateStr1 = "2011-10-1 10:20:16";
        String DateStr2 = "2011-10-07 15:50:35";
        DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        Date dateTime1 = null;
        try {
            dateTime1 = dateFormat.parse(DateStr1);
            Date dateTime2 = dateFormat.parse(DateStr2);
            int i = dateTime1.compareTo(dateTime2);
            System.out.println (i);
        } catch (ParseException e) {
            e.printStackTrace ();
        }
    }

    @Test
    public void test6(){
        LocalDate now = LocalDate.now ();
        List<Integer> list_xf = Arrays.asList(9,10,11,12,1,3,4,5,6);
        int i = list_xf.indexOf (6);
        System.out.println (i);
        System.out.println (list_xf.size ()-i);
    }

    @Test
    public void test7(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        String signYearType1 = "2022";
        String startTime = signYearType1+"-07-01";
        String endTime = (Integer.parseInt (signYearType1) + 1)+"-07-01";
        Date startDate = null;
        Date endDate = null;
        Date reportTime = null;
        try {
            startDate = simpleDateFormat.parse (startTime);
            endDate = simpleDateFormat.parse (endTime);
            reportTime = simpleDateFormat.parse ("2022-07-01");
            System.out.println (startDate);
            System.out.println (endDate);
        } catch (ParseException e) {
            e.printStackTrace ();
        }

        if (reportTime.compareTo(startDate) >= 0 && reportTime.compareTo(endDate) < 0){
            // 晚于学年开始时间 早于学年结束时间
            System.out.println ("1");
        }else {
            System.out.println ("2");
        }
    }

    @Test
    public void test8(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = fmt.parse ("2021-10-01");
        } catch (ParseException e) {
            e.printStackTrace ();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date today = c.getTime();//这是昨天
        String day = fmt.format(today);

        System.out.println (date1);
        System.out.println (day);
    }

    @Test
    public void test9(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月份是MM
        Date date = new Date ();
        System.out.println (sdf.format(date));
        date.setMinutes (date.getMinutes () - date.getTimezoneOffset ());
        System.out.println (sdf.format(date));
        Date date1 = new Date (28800000);
        System.out.println (sdf.format(date1));
    }

    @Test
    public void test10(){
        int num = 0;
        List<Integer> list = new ArrayList<>();
        while (num < 53){
            list.add (num);
            num++;
        }
        System.out.println (list.size ());
        List<Integer> list1 = new ArrayList<>();
        // list1 = list.subList (50, 60);
        for (int i = 0; i <= list.size () ; i+=10 ) {
            list1 = list.subList (i, (i + 10) > list.size () ? list.size () : i+10);
            System.out.println (list1);
        }
    }

    @Test
    public void test11(){
        String s = "{\"success\":true,\"code\":\"SUCCESS\",\"message\":\"操作成功\",\"data\":null,\"baseResultCodeEnum\":\"SUCCESS\"}";
        JSONObject jsonObject = JSONObject.parseObject (s);
        String success = jsonObject.getString ("success");
        String aaaa = jsonObject.getString ("aaaa");
        System.out.println (success);
        System.out.println (aaaa);
    }

    @Test
    public void test12(){
        List<Person> personList = Person.getPersonList ();
        // System.out.println (personList);
        // 按照name一样 计算成一条 生成新的list
        Map<String, BigDecimal> collect = personList.stream ()
                .collect (Collectors.groupingBy (Person::getName, CollectorsUtil.summingBigDecimal (Person::getMoney)));
        System.out.println (collect);
    }

    @Test
    public void test13(){
        List<String> list = Arrays.asList ("1", "2");
        List<String> list2 = Arrays.asList ("3");
        list.addAll(list2);
        System.out.println (list);
    }

    @Test
    public void test14(){
        String s = "202118000055_FX10";
        String[] fxes = s.split ("_FX");
        int i = Integer.parseInt (fxes[1]);
        i += 1;
        if (i < 9){
            String sno = String.format("%0"+2+"d",i);
            System.out.println (fxes[0]+"_FX"+sno);
        }else {
            System.out.println (fxes[0]+"_FX"+String.valueOf (i));
        }
    }

    @Test
    public void test15(){
        String s1 = "111";
        String s2 = "111_FX01";
        String s3 = "111_FX02";
        // String s4 = "111_ZXB01";
        List<String> list = new ArrayList<>();
        // list.add (s4);
        list.add (s2);
        list.add (s3);
        list.add (s1);
        List<String> collect = list.stream ()
                .sorted (Comparator.reverseOrder ())
                .collect (Collectors.toList ());
        System.out.println (collect);
        System.out.println (collect.get (0));
        System.out.println (collect.get (collect.size ()-1));
        List<String> collect1 = collect.stream ()
                // .filter (a -> a.contains ("_FX"))
                .filter (a -> a.contains ("_ZXB"))
                .collect (Collectors.toList ());
        System.out.println (collect1);
        // System.out.println (collect1.get (0));
    }

    @Test
    public void test16(){
        String beginTime = "2022-03-09 00:00:00";
        String endTime = "2018-07-29 12:26:32";
        SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = format.parse (beginTime);
            // Date date2 = format.parse (endTime);
            Date date2 = new Date ();
            boolean before = date1.before (date2);
            System.out.println (before);
        } catch (Exception e) {

        }
    }

    @Test
    public void test17(){
        List<Integer> integers = Arrays.asList (1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<List<Integer>> lists = BenUtil.averageAssign (integers, 4);
        System.out.println (lists.size ());
        System.out.println (lists);

    }

    int num = 0;

    @Test
    public void test18(){
        error2 ();
        try {
            System.out.println ("num1:"+num);
            // int i = 1/0;
            System.out.println ("try");
        }catch (Exception e){
            System.out.println ("num2:"+num);
            // e.printStackTrace ();
            System.out.println ("catch");
        }
        System.out.println ("num3:"+num);
        System.out.println ("end");
    }

    @Transactional( rollbackFor = Exception.class)
    public void error2() {
        System.out.println ("error2");
        num++;
        error1 ();
    }

    public void error1 () {
        System.out.println ("error");
        num++;
        throw new RuntimeException("123");
    }

    @Test
    public void test19(){
        List<Person> personList = Person.getPersonList ();
        Person p1 = personList.get (0);
        Person p2 = personList.get (1);
        BigDecimal a = new BigDecimal ("300");
        Pojo pojo = new Pojo ();
        pojo.setB (a);
        System.out.println (p1.getSalary ());
        System.out.println (p2.getSalary ());
        System.out.println (pojo.getB ());
        test19_2 (p1,p2,pojo);
        System.out.println (p1.getSalary ());
        System.out.println (p2.getSalary ());
        System.out.println (pojo.getB ());
    }

    public void test19_1(int a,int b){
        for (int i = 0; i < 10; i++) {
            a = a+1;
            if (i == 5){
                b++;
                break;
            }
        }
    }

    public void test19_2(Person p1, Person p2, Pojo pojo){
        for (int i = 0; i < 10; i++) {
            int salary = p1.getSalary ();
            salary++;
            p1.setSalary (salary);
            if (i == 5){
                BigDecimal a = pojo.getB ();
                a = a.add (new BigDecimal ("700"));
                pojo.setB (a);
                int salary1 = p2.getSalary ();
                salary1++;
                p2.setSalary (salary1);
                break;
            }
        }
    }

    @Test
    public void test20(){
        List<Integer> orderRegulation = Arrays.asList(3, 2, 6, 4, 9, 1, 8, 5, 7,0);
        List<Pojo> targetList = new ArrayList<Pojo>();
        Pojo pojo1 = new Pojo ();
        pojo1.setA (1);
        targetList.add(pojo1);
        Pojo pojo2 = new Pojo ();
        pojo2.setA (2);
        targetList.add(pojo2);
        Pojo pojo3 = new Pojo ();
        pojo3.setA (3);
        targetList.add(pojo3);
        Pojo pojo4 = new Pojo ();
        pojo4.setA (4);
        targetList.add(pojo4);
        System.out.println("排列前的数据：");
        targetList.forEach(t -> System.out.print(t.getA ()+"---"));
        System.out.println();
        BenUtil.setListOrder(orderRegulation, targetList);
        System.out.println("排列后的数据：");
        targetList.forEach(t -> System.out.print(t.getA ()+"---"));

    }

    @Test
    public void test21(){
        String a = "";
        String b = null;
        String c = "12";
        System.out.println (StrUtil.isBlank (a));
        System.out.println (StrUtil.isBlank (b));
        System.out.println (StrUtil.isBlank (c));
    }
}
