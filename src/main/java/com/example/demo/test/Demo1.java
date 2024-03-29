package com.example.demo.test;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.pojo.FinFeeDetail;
import com.example.demo.pojo.OrdOrderTermModel;
import com.example.demo.pojo.Person;
import com.example.demo.pojo.Pojo;
import com.example.demo.utils.BenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SpringBootTest
public class Demo1 {

    public static void main(String[] args) {
        String s = "9, 10, 11, 12, 1, 2, 3, 4, 5, 6";
        String[] split = s.split (",");
        List list = Arrays.asList (split);
        System.out.println (LocalDateTime.now());
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
    public void test01(){
        Double jc = 36000.0;
        Double gdzh = 5436.0;
        Double bfzh = 0.076;
        Double zh = 0.0;
        zh = (jc + gdzh) * (1.0 + bfzh);
        System.out.println (zh);
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
        BigDecimal a = new BigDecimal("22180.00");
        BigDecimal multiply = a.multiply (new BigDecimal ("14")).divide (new BigDecimal ("15"), 2, BigDecimal.ROUND_HALF_UP).subtract (a);
        BigDecimal multiply2 = a.multiply (new BigDecimal ("14")).divide (new BigDecimal ("15"), 2, RoundingMode.HALF_UP).subtract (a);

        // BigDecimal multiply = a.multiply (new BigDecimal (String.valueOf (5)).divide (new BigDecimal ("100"),2,BigDecimal.ROUND_HALF_UP));
        System.out.println (multiply);
        System.out.println (multiply2);
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
                // .collect (Collectors.groupingBy (Person::getName, CollectorsUtil.summingBigDecimal (Person::getMoney)));
                .collect (Collectors.groupingBy (Person::getName, Collectors.reducing(BigDecimal.ZERO, Person::getMoney, BigDecimal::add)));
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
                .filter (a -> !a.contains ("_"))
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

    @Test
    public void test22(){
        BigDecimal num = BigDecimal.ZERO;
        for (int i = 0; i < 10; i++) {
            num = num.add (new BigDecimal ("1"));
        }
        System.out.println (num);
    }

    @Test
    public void test23(){
        List<Person> personList = Person.getPersonList ();
        List<Person> alisaList = new ArrayList<>();
        alisaList.add (new Person ("Alisa", 7900, "female", "New York", new BigDecimal ("666")));
        alisaList.stream ().forEach (a -> {
            personList.add (a);
        });
        alisaList.get (0).setSalary (0);
        // personList.add (alisaList.get (0));
        System.out.println (personList);
    }

    @Test
    public void test24(){
        List<Person> personList = Person.getPersonList ();
        String name = null;
        name = personList.get (0).getName ();
        personList.get (0).setName ("1111");
        System.out.println (name);
        System.out.println (personList.get (0).getName ());
    }

    public List<Person> getPersonList(List<Person> personList){
        return personList;
    }

    @Test
    public void test25(){
        OrdOrderTermModel ordOrderTermModel = new OrdOrderTermModel ();
        if(ordOrderTermModel.getIsRefundPay ()){
            System.out.println ("1");
        }else {
            System.out.println ("0");
        }
    }

    @Test
    public void test26(){
        LocalDate parse = LocalDate.parse ("2022-09-01");
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = parse.atStartOfDay().atZone(zone).toInstant();
        System.out.println (Date.from(instant));
    }

    @Test
    public void test27(){
        // 1. 对于 String 列表去重
        List<String> stringList = new ArrayList<String> () {{
            add ("A"); add ("A"); add ("B"); add ("B"); add ("C");
        }};
        System.out.print ("去重前：");
        for (String s : stringList) {
            System.out.print (s);
        }
        System.out.println ();
        stringList = stringList.stream ().distinct ().collect (Collectors.toList ());
        System.out.print ("去重后：");
        for (String s : stringList) {
            System.out.print (s);
        }
        System.out.println ();
    }

    @Test
    public void test28(){
        // 入参
        List<String> stringList1 = new ArrayList<String> () {{
            add ("A"); add ("B"); add ("C"); add ("D"); add ("E");
        }};
        // 数据库
        List<String> stringList2 = new ArrayList<String> () {{
            add ("A"); add ("B"); add ("C"); add ("E");
        }};
        System.out.println (stringList1);
        System.out.println (stringList2);
        List<String> stringList3 = stringList1.stream ().filter (a -> {
            return !stringList2.contains (a);
        }).collect (Collectors.toList ());
        System.out.println (stringList3);
    }

    @Test
    public void test29(){
        FinFeeDetail finFeeDetail = new FinFeeDetail ();
        finFeeDetail.setIsFlow (false);
        List<Person> personList = change (finFeeDetail);
        System.out.println (finFeeDetail.getIsFlow ());
    }

    public List<Person> change(FinFeeDetail finFeeDetail){
        List<Person> personList = Person.getPersonList ();
        finFeeDetail.setIsFlow (true);
        return personList;
    }

    @Test
    public void test30(){
        try {
            error30 ();
        } catch (Exception e) {
            System.out.println ("报错咧");
        }
    }

    public void error30(){
        int i = 1;
        i = i / 0;
    }

    @Test
    public void test31() {
        //1.创建匹配模式
        Pattern pattern = Pattern.compile ("^[\\d-－+＋—]{0,20}$");
        String str = "010－5569844";
        //2.选择匹配对象
        if (StringUtils.isNotBlank (str)){
            Matcher matcher = pattern.matcher (str);
            //与谁匹配？与参数字符串str匹配
            boolean matches = matcher.matches();
            System.out.println(matches);
        }else {
            System.out.println ("null");
        }
    }

    @Test
    public void test32(){
        BigDecimal num = new BigDecimal ("10001");
        if ("".equals(num) || num == null){
            System.out.println ("null");
        }
        if (BigDecimal.ZERO.compareTo (num) == 0){
            System.out.println ("不能为0");
        }else {
            if (new BigDecimal (num.intValue ()).compareTo (num) != 0){
                System.out.println ("不为整数");
            }else {
                if ((new BigDecimal ("-10000").compareTo (num) > 0) || (new BigDecimal ("10000").compareTo (num) < 0)){
                    System.out.println ("-10000-10000以内");
                }
            }
        }
    }

    @Test
    public void test33(){
        List<Person> personList = Person.getPersonList ();
        List<String> stringList = Arrays.asList ("California", "New York", "Washington");
        List<Integer> stringList2 = Arrays.asList (5600,6000,6200,7000,7800,7900,8200,8300,8400,9500,9100);
        // List<Person> collect = personList.stream ().sorted (Comparator.comparing (Person::getSalary).reversed ()).collect (Collectors.toList ());
        Collections.sort (personList,((o1,o2) -> {
            int io1 = stringList2.indexOf (o1.getSalary ());
            int io2 = stringList2.indexOf (o2.getSalary ());
            if (io1 != -1){
                io1 = stringList2.size () - io1;
            }
            if (io2 != -1){
                io2 = stringList2.size () - io2;
            }
            return io2 - io1;
        }));
        personList.forEach (System.out::println);
        Collections.sort (personList,((o1,o2) -> {
            int io1 = stringList.indexOf (o1.getArea ());
            int io2 = stringList.indexOf (o2.getArea ());
            if (io1 != -1){
                io1 = personList.size () - io1;
            }
            if (io2 != -1){
                io2 = personList.size () - io2;
            }
            return io2 - io1;
        }));
        System.out.println ("-------------------------");
        personList.forEach (System.out::println);
    }

    @Test
    public void test34(){
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parseTime = LocalDateTime.parse("2022-12-16 00:00:00", pattern);
        Date date = Date.from (parseTime.atZone (ZoneId.systemDefault ()).toInstant ());
        System.out.println (date);
    }

    @Test
    public void test35(){
        List<Person> personList = Person.getPersonList ();
        Map<String, Integer> collect = personList.stream ().collect (Collectors.toMap (Person::getName, Person::getAge));
        System.out.println (collect);
    }

    @Test
    public void test36(){
        Map<String, List<String>> accountMap = new HashMap<> ();
        accountMap.put ("1",Arrays.asList ("1","2"));
        accountMap.put ("2",Arrays.asList ("1","2"));
        accountMap.put ("3",Arrays.asList ("1","2"));
        System.out.println (accountMap.get ("4"));
    }

    @Test
    public void test37(){
        String msg = "政府学位补贴减免费用说明：{name}学生您应交基础学费为{amount1}元/学年，在小学阶段将享受政府学位补贴费4200元/学年（中途转入转出按月折算），最终您应交基础学费为{amount2}元/学年。";
        msg = msg.replace ("{name}","AAA");
        // msg.replace ("{amount1}",btTimelinessAmount.add (disAmount).toString ());
        // msg.replace ("{amount2}",btTimelinessAmount.toString ());
        System.out.println (msg);
    }

    @Test
    public void test38(){
        BigDecimal a = new BigDecimal ("4000");
        BigDecimal c = new BigDecimal ("2000");
        a.add (c);
        System.out.println (a);
    }

    @Test
    public void test39(){
        String a = "sda";
        String[] split = a.split (",");
        System.out.println (split.length);
        System.out.println (split[0]);
        // System.out.println (split[1]);
    }

    @Test
    public void test40(){
        String[] arrays = {"dasda","Adasd"};
        List<String> strings = Arrays.asList (arrays);
        strings.add ("asdsa");
    }

    @Test
    public void test41(){
        String s = "TMBM23123011";
        if(s.startsWith("TM")){
            s = s.substring (2, s.length () - 1);
        }
        System.out.println (s);
    }

    @Test
    public void test42(){
        FinFeeDetail f = new FinFeeDetail ();
        Person p = new Person ();
        p.setName (f.getItemName ());
    }

    @Test
    public void test43(){
        Map<String,List<Person>> map = new HashMap ();
        List<Person> personList = Person.getPersonList ();
        System.out.println (personList.get (0).getName ());
        map.put ("1",personList);
        List<Person> personList2 = new ArrayList<> ();
        for (Person person : personList) {
            personList2.add (ObjectUtil.clone (person));
        }
        map.put ("2", personList2);
        map.get("2").forEach (a -> a.setName ("233123"));
        System.out.println (map.get ("1").get (0).getName ());
        System.out.println (map.get ("2").get (0).getName ());
    }

    @Test
    public void test44(){
        FinFeeDetail f = new FinFeeDetail ();
        f.setItemCode ("33");
        FinFeeDetail f2 = new FinFeeDetail ();
        BeanUtils.copyProperties (f,f2);
        f.setItemCode ("22");
        System.out.println (f2.getItemCode ());
    }

    @Test
    public void test45(){
        System.out.println (cn.hutool.core.lang.UUID.randomUUID ().toString ());
    }

    @Test
    public void test46(){
        String num = "";
        System.out.println (StringUtils.isBlank (num));
        System.out.println ("".equals (num));
    }

    @Test
    public void test47(){
        StopWatch stopWatch = new StopWatch ();
        stopWatch.start ();
        int num = 0;
        for (int i = 0;i<10000;i++){
            num = num + Math.round (10);
        }
        System.out.println (num);
        stopWatch.stop ();
        System.out.println (stopWatch.getTotalTimeMillis ());
        System.out.println (stopWatch.getTotalTimeSeconds ());
    }

    @Test
    public void test48(){
        List<Person> personList = Person.getPersonList ();
        List<Person> collect = personList.stream ().filter (a -> !"Tom".equals (a.getName ()) && !"Ato".equals (a.getName ())).collect (Collectors.toList ());
        System.out.println (collect);
    }

    @Test
    public void test49(){
        Random rand = new Random();
        String num = Integer.toString(rand.nextInt(10));
        System.out.println (num);
        System.out.println (!"1".equals (num));
    }

    @Test
    public void test50(){
        String amount = "-160";
        BigDecimal bigDecimal160 = new BigDecimal (amount);
        BigDecimal bigDecimal80 = bigDecimal160.divide (new BigDecimal (2), 2, RoundingMode.HALF_UP);
        System.out.println (bigDecimal160);
        System.out.println (bigDecimal80);
    }

    @Test
    public void test51(){
        List list = new ArrayList();
        String num = null;
        list.add (Person.getPersonList ());
        list.add (num);
        System.out.println (null == list.get (1));
    }

    @Test
    public void test52(){
        Random random = new Random ();
        String a = String.valueOf (random.nextInt (10));
        System.out.println (a);
        System.out.println ("1".equals (a) ? "yi" : "er");
    }

    @Test
    public void test53(){
        List<Person> personList = new ArrayList<Person> ();
        personList.add (new Person ("Tom", 6000, "male", "New York", new BigDecimal ("333")));
        personList.add (new Person ("Ato", 6000, "male", "New York", new BigDecimal ("333")));
        personList.add (new Person ("Kal", 6000, "male", "New York", new BigDecimal ("333")));
        personList.add (new Person ("Kal", 6000, "male", "New York", new BigDecimal ("333")));
        Set<String> uniqueKeys = new HashSet<>();
        List<Person> filteredList = new ArrayList<>();

        for (Person info : personList) {
            String key = info.getName () + info.getSex () + info.getArea ();
            if (!uniqueKeys.contains(key)) {
                uniqueKeys.add(key);
                filteredList.add(info);
            }
        }

        // 打印过滤后的数据
        for (Person info : filteredList) {
            System.out.println(info.getName() + ", " + info.getSex() + ", " + info.getArea());
        }
    }

    @Test
    public void test54() {

        List<Person> list = new ArrayList<> ();
        Person obj1 = new Person ("Tom", 4000, "male", "New York", new BigDecimal ("333"));
        list.add (obj1);
        Person obj2 = new Person ("Ato", 7000, "male", "New York", new BigDecimal ("333"));
        list.add (obj2);
        Person obj3 = new Person ("Kal", 8000, "male", "New York", new BigDecimal ("333"));
        list.add (obj3);
        List<Person> young = list.stream ().filter (e -> e.getSalary () <= 7000).collect (Collectors.toList ());
        List<Person> children = list.stream ().filter (e -> e.getSalary () < 5000).collect (Collectors.toList ());
        HashMap map = new HashMap ();
        map.put ("young", young);
        map.put ("children", children);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        String jsonString2 = JSON.toJSONString(map,SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(jsonString2);
    }

    @Test
    public void test55() {
        List<FinFeeDetail> list = new ArrayList<> ();
        FinFeeDetail f1 = new FinFeeDetail ();
        f1.setIsDeleted (false);
        f1.setItemCode ("1");
        list.add (f1);
        FinFeeDetail f2 = new FinFeeDetail ();
        f2.setIsDeleted (true);
        f2.setItemCode ("2");
        list.add (f2);
        FinFeeDetail f3 = new FinFeeDetail ();
        f3.setIsDeleted (true);
        f3.setItemCode ("3");
        list.add (f3);
        list.removeIf (FinFeeDetail::getIsDeleted);
        String jsonString = JSON.toJSONString(list);
        System.out.println (jsonString);
    }

    @Test
    public void test56() throws JsonProcessingException {
        // {"snoString":"value1","signYearType":"value2","consumeCategory":"value3","itemCode":"value4","day":"value5"}
        // String s = "{\"snoString\":\"202201134252,20211110926\",\"signYearType\":\"2023\",\"consumeCategory\":null,\"itemCode\":\"value4\",\"day\":\"value5\"}";
        // String s = "{\"snoString\":\"202201134252,20211110926\",\"signYearType\":\"2023\"}";
        String s = "{\"snoString\":\"20210129919_ZX01,20190311408_ZX01,20210131628_ZX01,202101132714_ZX01,202101133071_ZX01,20200129093_ZX01,20200129027_ZX01,20200129046_ZX01,20200128987_ZX01,202101132747_ZX01,301675_ZX01,20190114862_ZX01,20190309936_ZX01,20190312332_ZX01,20190312398_ZX01,20200115859_ZX01,20200313124_ZX01,20200314036_ZX01,20200611730_ZX01,202201133586_ZX01,202101132884_ZX01,20210131117_ZX01,20210130272_ZX01,20210100216_ZX01,20210100193_ZX01,20210130273_ZX01,20210100217_ZX01,20200117209_ZX01,20200129003_ZX01,20200129119_ZX01,20200129141_ZX01,20200129069_ZX01,20200129070_ZX01,20200129149_ZX01,20200129074_ZX01,20210129390_ZX01,20210129292_ZX01,20210129534_ZX01,20180301723_ZX01,20200313633_ZX01,20200313096_ZX01,20210325634_ZX01,20200324968_ZX01,20200324975_ZX01,20210325103_ZX01,20180306009_ZX01,20200324951_ZX01,20210325506_ZX01,20200325054_ZX01,20210325281_ZX01,20210325108_ZX01,20200324953_ZX01,202103126441_ZX01,20200312880_ZX01,20200324960_ZX01,20210326166_ZX01,20210325476_ZX01,20200325055_ZX01,20200312716_ZX01,108737_ZX01,202201135492_ZX01,20210130795_ZX01,20210130104_ZX01,20210129528_ZX01,20200129039_ZX01,202101132342_ZX01,202101132868_ZX01,20200115626_ZX01,43769_ZX01,20200129235_ZX01,20200129020_ZX01,20210129405_ZX01,20210129351_ZX01,20210100276_ZX01,20200129021_ZX01,20200129006_ZX01,20200129038_ZX01,20210100184_ZX01,20200114986_ZX01,20190114581_ZX01,20210130209_ZX01,20200115114_ZX01,396546_ZX01,202201137760_ZX01,202202126826_ZX01,202202127403_ZX01,202213103218_ZX01,202216000140_ZX02,202216000298_ZX01,20211300725_ZX01,20200116406_ZX01,20200612010_ZX01,20200115233_ZX01,20190112433_ZX01,20200115248_ZX01,9552_ZX01,202301137767_ZX01,202301140161_ZX01,20200313301_ZX02,20200115256_ZX02,20180108321_ZX02,20190311464_ZX02,20200313707_ZX01,202303128776_ZX01,202301140691_ZX01,202301140690_ZX01,202301139639_ZX01,202301138806_ZX01,202201137908_ZX01,202201136942_ZX02,202201136221_ZX01,202201134572_ZX02,202201134539_ZX01,202301140712_ZX01,202301140663_ZX01,202301140659_ZX01,202301140375_ZX01,202301140409_ZX01,202301140289_ZX01,202301140065_ZX01,202301139217_ZX01,202301139112_ZX01,202201135910_ZX01,202201135909_ZX01,202201134722_ZX01,20190112789_ZX02,20180103857_ZX02,202316000710_ZX01,202301140496_ZX01,202301138931_ZX01,202201134572_ZX03,202201134539_ZX02,202201136942_ZX03,202201137908_ZX02,202301138806_ZX02,202301139639_ZX02,202301140691_ZX02,202301140289_ZX02,202301139112_ZX02,202301140663_ZX02,202201135909_ZX02,202201135910_ZX02,202202127679_ZX01,202201134722_ZX02,202301139217_ZX02,202301140409_ZX02,202301140712_ZX02,202301140065_ZX02,202201136221_ZX02,202301140690_ZX02,20190112789_ZX03,202301140375_ZX02,202301140659_ZX02\",\"signYearType\":\"2023\"}";
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串转换为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(s);

        // 获取参数值
        String snoString = jsonNode.get("snoString").asText();
        String signYearType = jsonNode.get("signYearType").asText();
        String consumeCategory = null;
        if (jsonNode.has("consumeCategory")) {
            consumeCategory = jsonNode.get("consumeCategory").asText();
        }
        String itemCode = null;
        if (jsonNode.has("itemCode")) {
            itemCode = jsonNode.get("itemCode").asText();
        }
        String day = null;
        if (jsonNode.has("day")) {
            day = jsonNode.get("day").asText();
        }

        System.out.println (snoString);
        System.out.println (snoString.split (",").length);
        System.out.println (snoString.split (",")[0]);
        System.out.println (signYearType);
        System.out.println (consumeCategory);
        System.out.println (itemCode);
        System.out.println (day);
    }

    @Test
    public void test57(){
        String s = "2021-2022";
        if (s.contains ("-")) {
            String[] split = s.split ("-");
            String s1 = split[0];
            int s2 = Integer.parseInt (split[1]);
            System.out.println (s1);
            System.out.println (s2);
            if (s1 == null) {
                System.out.println ("null");
            }else {
                System.out.println ("not null");
            }
        }
    }

    @Test
    public void test58() throws ParseException {
        String time = "2018-07-29 12:26:32";
        SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        Date date1 = format.parse (time);
        // Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        int dayOfMonth = Integer.parseInt(sdf.format(date1));
        if (dayOfMonth >= 1 && dayOfMonth <= 10) {
            System.out.println ("第一旬");
        } else if (dayOfMonth >= 11 && dayOfMonth <= 20) {
            System.out.println ("第二旬");
        } else {
            System.out.println ("第三旬");
        }
    }

    @Test
    public void test59() {
        String signYearType = "2021";
        String month = "2";
        String xun = "3";
        int year = Integer.parseInt(signYearType);
        int monthValue = Integer.parseInt(month);
        int xunValue = Integer.parseInt(xun);

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthValue - 1, 1); // 设置为指定年月的第一天

        if (xunValue == 1) {
            calendar.set(Calendar.DAY_OF_MONTH, 10);
        } else if (xunValue == 2) {
            calendar.set(Calendar.DAY_OF_MONTH, 20);
        } else if (xunValue == 3) {
            int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            calendar.set(Calendar.DAY_OF_MONTH, lastDayOfMonth);
        }
        Date sendDate = calendar.getTime ();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(sendDate);
        System.out.println("传出参数：" + formattedDate);
    }

    @Test
    public void test60() {
        List<String> dateStringList = Arrays.asList(
                "2023-09-01", "2023-09-11", "2023-09-21", "2023-10-01", "2023-10-11", "2023-10-21",
                "2023-11-01", "2023-11-11", "2023-11-21", "2023-12-01", "2023-12-11", "2023-12-21",
                "2024-01-01", "2024-01-11", "2024-01-21"
        );
        String inputDate = "2023-09-11";
        LocalDate inputLocalDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);

        List<String> result = dateStringList.stream()
                .filter(date -> LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE).isAfter(inputLocalDate))
                .collect(Collectors.toList());

        System.out.println("范围是：" + result);
    }
}
