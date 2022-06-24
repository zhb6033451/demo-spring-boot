package com.example.demo.test.fushidemo;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.example.demo.pojo.Fushi;
import com.example.demo.pojo.FushiList;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class FushiDemo1 {

    @Test
    public void test1() {
        // 开始时间
        System.out.println ("开始时间: "+LocalDateTime.now());
        // 位置数组
        String[] counts = {"1", "2", "3", "4", "5", "6"};
        //
        List<FushiList> zhFushiList = new ArrayList ();
        ExcelReader reader = ExcelUtil.getReader ("E:/坚果云同步/我的坚果云/我的坚果云/游戏/爆裂魔女/model.xlsx");
        List<Fushi> fushis = reader.readAll (Fushi.class);
        // 首先根据位置分组,共6组
        List<Fushi> count1 = fushis.stream ().filter (a -> counts[0].equals (a.getCount ())).collect (Collectors.toList ());
        List<Fushi> count2 = fushis.stream ().filter (a -> counts[1].equals (a.getCount ())).collect (Collectors.toList ());
        List<Fushi> count3 = fushis.stream ().filter (a -> counts[2].equals (a.getCount ())).collect (Collectors.toList ());
        List<Fushi> count4 = fushis.stream ().filter (a -> counts[3].equals (a.getCount ())).collect (Collectors.toList ());
        List<Fushi> count5 = fushis.stream ().filter (a -> counts[4].equals (a.getCount ())).collect (Collectors.toList ());
        List<Fushi> count6 = fushis.stream ().filter (a -> counts[5].equals (a.getCount ())).collect (Collectors.toList ());
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int num6 = 0;
        int cs = 0;
        ok:
        for (; ; ) {
            cs++;
            List<Fushi> fushiList = new ArrayList<> ();
            for (int i = 0; i < counts.length; i++) {
                if (i == 0) {
                    Fushi fushi1 = count1.get (num1);
                    fushiList.add (fushi1);
                } else if (i == 1) {
                    Fushi fushi2 = count2.get (num2);
                    fushiList.add (fushi2);
                } else if (i == 2) {
                    Fushi fushi3 = count3.get (num3);
                    fushiList.add (fushi3);
                } else if (i == 3) {
                    Fushi fushi4 = count4.get (num4);
                    fushiList.add (fushi4);
                } else if (i == 4) {
                    Fushi fushi5 = count5.get (num5);
                    fushiList.add (fushi5);
                } else if (i == 5) {
                    Fushi fushi6 = count6.get (num6);
                    fushiList.add (fushi6);
                    // 判断名称是否符合
                    if (qc (fushiList)){
                        FushiList zh = getZh (fushiList);
                        zhFushiList.add(zh);
                    }
                    // 判断第一位置顺序
                    if (num1 == count1.size ()-1){
                        // 第一位置顺序已经到第一组末尾 开始判断第二位置顺序
                        if (num2 == count2.size ()-1){
                            // 第二位置顺序已经到第二组末尾 开始判断第三位置顺序
                            if (num3 == count3.size ()-1){
                                // 第三位置顺序已经到第三组末尾 开始判断第四位置顺序
                                if (num4 == count4.size ()-1){
                                    // 第四位置顺序已经到第二组末尾 开始判断第五位置顺序
                                    if (num5 == count5.size () - 1) {
                                        // 第五位置顺序已经到第五组末尾 开始判断第六位置顺序
                                        if (num6 == count6.size () - 1) {
                                            // 第六位置顺序已经到第六组末尾 跳出循环
                                            break ok;
                                        } else {
                                            // 第六位置顺序+1
                                            num6++;
                                            // 第五位置顺序清零
                                            num5 = 0;
                                            // 第四位置顺序清零
                                            num4 = 0;
                                            // 第三位置顺序清零
                                            num3 = 0;
                                            // 第二位置顺序清零
                                            num2 = 0;
                                            // 第一位置顺序清零
                                            num1 = 0;
                                        }
                                    } else {
                                        // 第五位置顺序+1
                                        num5++;
                                        // 第四位置顺序清零
                                        num4 = 0;
                                        // 第三位置顺序清零
                                        num3 = 0;
                                        // 第二位置顺序清零
                                        num2 = 0;
                                        // 第一位置顺序清零
                                        num1 = 0;
                                    }
                                }else {
                                    // 第四位置顺序+1
                                    num4++;
                                    // 第三位置顺序清零
                                    num3 = 0;
                                    // 第二位置顺序清零
                                    num2 = 0;
                                    // 第一位置顺序清零
                                    num1 = 0;
                                }
                            }else {
                                // 第三位置顺序+1
                                num3++;
                                // 第二位置顺序清零
                                num2 = 0;
                                // 第一位置顺序清零
                                num1 = 0;
                            }
                        }else {
                            // 第二位置顺序+1
                            num2++;
                            // 第一位置顺序清零
                            num1 = 0;
                        }
                    }else {
                        // 第一位置顺序+1
                        num1++;
                    }
                }
            }
        }
        System.out.println ("共循环次数: "+cs);
        System.out.println ("所有符合名称规定的组合数量: " + zhFushiList.size ());
        System.out.println ("-------名称过滤完毕---------");
        // 结束时间
        System.out.println ("结束时间: "+LocalDateTime.now());
        System.out.println ("----------数值排序过滤完毕------------");
        // 总和降序
        List<FushiList> fushiListByZh = zhFushiList.stream ().sorted (Comparator.comparing (FushiList::getZh).reversed ()).collect (Collectors.toList ());
        int countttt1 = 0;
        for (FushiList zh : fushiListByZh) {
            countttt1++;
            if (countttt1<0){
                zh.getFushiList ().forEach (b -> System.out.println (b));
                System.out.println ("固定总和 :" + zh.getGdzh () + "百分总和: " + zh.getBfzh () + " 最终数值: " + zh.getZh () );
                System.out.println ("------------");
            }
        }
        System.out.println ("----------取去重后前6套------------");
        List<FushiList> fourFushiList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            FushiList fushiList = fushiListByZh.get (0);
            fourFushiList.add(fushiList);
            fushiListByZh = getOne (fushiListByZh);
        }
        for (FushiList zh : fourFushiList) {
            zh.getFushiList ().forEach (b -> System.out.println (b));
            System.out.println ("固定总和 :" + zh.getGdzh () + "百分总和: " + zh.getBfzh () + " 最终数值: " + zh.getZh () );
            System.out.println ("------------");
        }
    }

    public List<FushiList> getOne(List<FushiList> fushiListByZh){
        FushiList fushiList = fushiListByZh.get (0);
        fushiListByZh.remove (fushiList);
        List<FushiList> fushiListByZh1 = fushiListByZh.stream ().filter (a -> {
            boolean flag = true;
            for (int i = 0; i < 6; i++) {
                Integer num = fushiList.getFushiList ().get (i).getNum ();
                Integer num1 = a.getFushiList ().get (i).getNum ();
                if (num == num1) {
                    // 若序号相同,则说明元素重复,需去除
                    flag = false;
                    break;
                }
            }
            return flag;
        }).collect (Collectors.toList ());
        return fushiListByZh1;
    }

    /**
     * 根据基础数据,计算出最终数据  公式:最终数据 = (基础数据+固定数值)*(1+百分数值)
     * @param fushiList
     * @return
     */
    public FushiList getZh(List<Fushi> fushiList){
        Double jc = 36000.0;
        Double gdzh = 0.0;
        Double bfzh = 0.0;
        Double zh = 0.0;
        for (Fushi fushi : fushiList) {
            gdzh = gdzh + fushi.getGd ();
            bfzh = bfzh + fushi.getBf ();
        }
        zh = (jc + gdzh) * (1.0 + bfzh);
        FushiList list = new FushiList ();
        list.setFushiList (fushiList);
        list.setGdzh (gdzh);
        list.setBfzh (bfzh);
        list.setZh (zh);
        return list;
    }

    /**
     * 判断名称是否符合,是->符合 否->不符合
     * @param fushiList
     * @return
     */
    public boolean qc(List<Fushi> fushiList){
        boolean flag = true;
        List<Fushi> fushiListTemp = fushiList;
        List<Fushi> collect1 = fushiListTemp.stream ().filter (a -> fushiListTemp.get (0).getName ().equals (a.getName ())).collect (Collectors.toList ());
        if (collect1.size () == 2) {
            List<Fushi> collect2 = fushiListTemp.stream ().filter (a -> !collect1.get (0).getName ().equals (a.getName ())).collect (Collectors.toList ());
            List<Fushi> collect3 = collect2.stream ().filter (a -> collect2.get (0).getName ().equals (a.getName ())).collect (Collectors.toList ());
            if (collect3.size () == 2) {
                List<Fushi> collect4 = collect2.stream ().filter (a -> !collect3.get (0).getName ().equals (a.getName ())).collect (Collectors.toList ());
                List<Fushi> collect5 = collect4.stream ().filter (a -> collect4.get (0).getName ().equals (a.getName ())).collect (Collectors.toList ());
                if (collect5.size () != 2) {
                    flag = false;
                }
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }
        return flag;
    }

}
