package com.example.demo.test.fushidemo;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.example.demo.pojo.Fushi;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class FushiDemo {

    @Test
    public void test(){
        // 名称数组
        String[] names = {"斗争", "怒火", "觉醒", "希望"};
        // 位置数组
        String[] counts = {"1", "2", "3", "4", "5", "6"};
        //
        List<List<Fushi>> zhFushiList = new ArrayList();
        ExcelReader reader = ExcelUtil.getReader ("E:/坚果云同步/我的坚果云/我的坚果云/游戏/爆裂魔女/model.xlsx");
        List<Fushi> fushis = reader.readAll (Fushi.class);
        // 首先根据位置分组,共6组,按照名称再分组,共24组
        List<Fushi> count1 = fushis.stream ().filter (a -> counts[0].equals (a.getCount ())).collect (Collectors.toList ());
        // List<Fushi> count1Name斗争 = count1.stream ().filter (a -> names[0].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count1Name怒火 = count1.stream ().filter (a -> names[1].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count1Name觉醒 = count1.stream ().filter (a -> names[2].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count1Name希望 = count1.stream ().filter (a -> names[3].equals (a.getName ())).collect (Collectors.toList ());
        List<Fushi> count2 = fushis.stream ().filter (a -> counts[1].equals (a.getCount ())).collect (Collectors.toList ());
        // List<Fushi> count2Name斗争 = count2.stream ().filter (a -> names[0].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count2Name怒火 = count2.stream ().filter (a -> names[1].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count2Name觉醒 = count2.stream ().filter (a -> names[2].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count2Name希望 = count2.stream ().filter (a -> names[3].equals (a.getName ())).collect (Collectors.toList ());
        List<Fushi> count3 = fushis.stream ().filter (a -> counts[2].equals (a.getCount ())).collect (Collectors.toList ());
        // List<Fushi> count3Name斗争 = count3.stream ().filter (a -> names[0].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count3Name怒火 = count3.stream ().filter (a -> names[1].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count3Name觉醒 = count3.stream ().filter (a -> names[2].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count3Name希望 = count3.stream ().filter (a -> names[3].equals (a.getName ())).collect (Collectors.toList ());
        List<Fushi> count4 = fushis.stream ().filter (a -> counts[3].equals (a.getCount ())).collect (Collectors.toList ());
        // List<Fushi> count4Name斗争 = count4.stream ().filter (a -> names[0].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count4Name怒火 = count4.stream ().filter (a -> names[1].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count4Name觉醒 = count4.stream ().filter (a -> names[2].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count4Name希望 = count4.stream ().filter (a -> names[3].equals (a.getName ())).collect (Collectors.toList ());
        List<Fushi> count5 = fushis.stream ().filter (a -> counts[4].equals (a.getCount ())).collect (Collectors.toList ());
        // List<Fushi> count5Name斗争 = count5.stream ().filter (a -> names[0].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count5Name怒火 = count5.stream ().filter (a -> names[1].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count5Name觉醒 = count5.stream ().filter (a -> names[2].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count5Name希望 = count5.stream ().filter (a -> names[3].equals (a.getName ())).collect (Collectors.toList ());
        List<Fushi> count6 = fushis.stream ().filter (a -> counts[5].equals (a.getCount ())).collect (Collectors.toList ());
        // List<Fushi> count6Name斗争 = count6.stream ().filter (a -> names[0].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count6Name怒火 = count6.stream ().filter (a -> names[1].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count6Name觉醒 = count6.stream ().filter (a -> names[2].equals (a.getName ())).collect (Collectors.toList ());
        // List<Fushi> count6Name希望 = count6.stream ().filter (a -> names[3].equals (a.getName ())).collect (Collectors.toList ());
        // 位置之间名称是否一致
        boolean wz12 = false;
        boolean wz13 = false;
        boolean wz14 = false;
        boolean wz15 = false;
        boolean wz16 = false;
        boolean wz23 = false;
        boolean wz24 = false;
        boolean wz25 = false;
        boolean wz26 = false;
        boolean wz34 = false;
        boolean wz35 = false;
        boolean wz36 = false;
        boolean wz45 = false;
        boolean wz46 = false;
        boolean wz56 = false;
        Fushi fushi1 = null;
        Fushi fushi2 = null;
        Fushi fushi3 = null;
        Fushi fushi4 = null;
        Fushi fushi5 = null;
        Fushi fushi6 = null;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int num6 = 0;
        ok:for(;;){
            List<Fushi> fushiList = new ArrayList<>();
            for (int i = 0; i < counts.length; i++) {
                if (i == 0) {
                    wz12 = false;
                    wz13 = false;
                    wz14 = false;
                    wz15 = false;
                    wz16 = false;
                    wz23 = false;
                    wz24 = false;
                    wz25 = false;
                    wz26 = false;
                    wz34 = false;
                    wz35 = false;
                    wz36 = false;
                    wz45 = false;
                    wz46 = false;
                    wz56 = false;
                    fushi1 = null;
                    fushi2 = null;
                    fushi3 = null;
                    fushi4 = null;
                    fushi5 = null;
                    fushi6 = null;
                    // 从位置1开始,从位置组中取出一个元素,并获得其名称,放到组合List中
                    if (count1.size ()==0){
                        break ok;
                    }
                    fushi1 = count1.get (num1);
                    count1.remove (fushi1);
                    fushiList.add (fushi1);
                } else if (i == 1) {
                    // 然后从位置2组中取出一个元素,并获得其名称
                    if (count2.size ()==0){
                        break ok;
                    }
                    fushi2 = count2.get (num2);
                    count2.remove (fushi2);
                    fushiList.add (fushi2);
                    // 判断位置12名称是否一致
                    if (fushi1.getName ().equals (fushi2.getName ())) {
                        wz12 = true;
                    }
                } else if (i == 2) {
                    if (count3.size ()==0){
                        break ok;
                    }
                    if (wz12) {
                        // 若位置1和位置2的名称一致,则位置3不能取该名称的元素,位置13,位置23,名称不一致
                        List<Fushi> count3_1 = count3.stream ().filter (a -> !fushiList.get (0).getName ().equals (a.getName ())).collect (Collectors.toList ());
                        fushi3 = count3_1.get (0);
                    } else {
                        // 若位置12名称不一致,则位置3随意取;需判断位置13,位置23,名称是否一致
                        fushi3 = count3.get (0);
                        if (fushi1.equals (fushi3.getName ())) {
                            wz13 = true;
                        }
                        if (fushi2.getName ().equals (fushi3.getName ())) {
                            wz23 = true;
                        }
                    }
                    count3.remove (fushi3);
                    fushiList.add (fushi3);
                } else if (i == 3) {
                    if (count4.size ()==0){
                        break ok;
                    }
                    if (wz12){
                        // 若位置12名称一致,则位置3和12不一致,则位置4除了12名称之外随意取;需判断位置34是否一致
                        List<Fushi> count4_1 = count4.stream ().filter (a -> !fushiList.get (0).getName ().equals (a.getName ())).collect (Collectors.toList ());
                        fushi4 = count4_1.get (0);
                        if (fushi3.getName ().equals (fushi4.getName ())) {
                            wz34 = true;
                        }
                    }else {
                        // 若位置12名称不一致,则判断位置13,位置23名称是否一致;
                        if (wz13){
                            // 若位置13名称一致,则位置2和13不一致,则位置4除了13名称之外随意取;需判断位置24是否一致
                            List<Fushi> count4_2 = count4.stream ().filter (a -> !fushiList.get (0).getName ().equals (a.getName ())).collect (Collectors.toList ());
                            fushi4 = count4_2.get (0);
                            if (fushi2.getName ().equals (fushi4.getName ())) {
                                wz24 = true;
                            }
                        }else if (wz23){
                            // 若位置23名称一致,则位置1和23不一致,则位置4除了23名称之外随意取;需判断位置14是否一致
                            List<Fushi> count4_3 = count4.stream ().filter (a -> !fushiList.get (1).getName ().equals (a.getName ())).collect (Collectors.toList ());
                            fushi4 = count4_3.get (0);
                            if (fushi1.getName ().equals (fushi4.getName ())) {
                                wz14 = true;
                            }
                        }
                    }
                    count4.remove (fushi4);
                    fushiList.add(fushi4);
                } else if (i == 4){
                    if (count5.size ()==0){
                        break ok;
                    }
                    if (wz12){
                        // 若位置12名称一致,则判断位置34是否一致;
                        if (wz34){
                            // 若位置34名称一致,则位置5除了12,34名称之外随意取;且位置5和位置12,位置34不一致
                            List<Fushi> count5_1 = count5.stream ().filter (a -> !fushiList.get (0).getName ().equals (a.getName ()))
                                    .filter (a -> !fushiList.get (2).getName ().equals (a.getName ())).collect (Collectors.toList ());
                            fushi5 = count5_1.get (0);
                        }else {
                            // 若位置34名称不一致,则位置5取34名称其中一个;需判断位置35,45是否一致
                            List<Fushi> count5_2 = count5.stream ().filter (a -> fushiList.get (2).getName ().equals (a.getName ())
                                    || fushiList.get (3).getName ().equals (a.getName ())).collect (Collectors.toList ());
                            fushi5 = count5_2.get (0);
                            if (fushi3.getName ().equals (fushi5.getName ())) {
                                wz35 = true;
                            }
                            if (fushi4.getName ().equals (fushi5.getName ())) {
                                wz45 = true;
                            }
                        }
                    }else {
                        // 若位置12名称不一致,则判断34名称是否一致
                        if (wz34){
                            // 若位置34名称一致,则位置5取12名称其中一个;需判断位置15,25是否一致
                            List<Fushi> count5_3 = count5.stream ().filter (a -> fushiList.get (0).getName ().equals (a.getName ())
                                    || fushiList.get (1).getName ().equals (a.getName ())).collect (Collectors.toList ());
                            fushi5 = count5_3.get (0);
                            if (fushi1.getName ().equals (fushi5.getName ())) {
                                wz15 = true;
                            }
                            if (fushi2.getName ().equals (fushi5.getName ())) {
                                wz25 = true;
                            }
                        }else {
                            // 若位置34名称不一致,则判断位置13名称是否一致
                            if (wz13){
                                // 若位置13名称一致,则判断位置24名称是否一致
                                if (wz24){
                                    // 若位置24名称一致,则位置5除了13,24名称之外随意取;且位置5和位置13,24不一致
                                    List<Fushi> count5_4 = count5.stream ().filter (a -> !fushiList.get (0).getName ().equals (a.getName ()))
                                            .filter (a -> !fushiList.get (1).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                    fushi5 = count5_4.get (0);
                                }else {
                                    // 若位置24名称不一致,则位置5取24名称其中一个;需判断位置25,45是否一致
                                    List<Fushi> count5_5 = count5.stream ().filter (a -> fushiList.get (1).getName ().equals (a.getName ())
                                            || fushiList.get (3).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                    fushi5 = count5_5.get (0);
                                    if (fushi2.getName ().equals (fushi5.getName ())) {
                                        wz25 = true;
                                    }
                                    if (fushi4.getName ().equals (fushi5.getName ())) {
                                        wz45 = true;
                                    }
                                }
                            }else {
                                // 若位置13名称不一致,则位置14名称肯定一致,则判断位置23名称是否一致
                                if (wz23){
                                    // 若位置23名称一致,则位置5除了14,23名称之外随意取;且位置5和位置14,23不一致
                                    List<Fushi> count5_6 = count5.stream ().filter (a -> !fushiList.get (0).getName ().equals (a.getName ()))
                                            .filter (a -> !fushiList.get (1).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                    fushi5 = count5_6.get (0);
                                }else {
                                    // 若位置23名称不一致,位置5取23名称其中一个;需判断位置25,35是否一致
                                    List<Fushi> count5_7 = count5.stream ().filter (a -> fushiList.get (1).getName ().equals (a.getName ())
                                            || fushiList.get (2).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                    fushi5 = count5_7.get (0);
                                    if (fushi2.getName ().equals (fushi5.getName ())) {
                                        wz25 = true;
                                    }
                                    if (fushi3.getName ().equals (fushi5.getName ())) {
                                        wz35 = true;
                                    }
                                }
                            }
                        }
                    }
                    count5.remove (fushi5);
                    fushiList.add(fushi5);
                } else if (i == 5){
                    if (count6.size ()==0){
                        break ok;
                    }
                    if (wz12){
                        // 若位置12名称一致,则判断位置34名称是否一致
                        if (wz34){
                            // 若位置34名称一致,位置6取位置5名称;
                            List<Fushi> count6_1 = count6.stream ().filter (a -> fushiList.get (4).getName ().equals (a.getName ())).collect (Collectors.toList ());
                            fushi6 = count6_1.get (0);
                        }else {
                            // 若位置34名称不一致,则判断35名称是否一致
                            if (wz35){
                                // 若位置35名称一致,则位置6取位置4名称;
                                List<Fushi> count6_2 = count6.stream ().filter (a -> fushiList.get (3).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                fushi6 = count6_2.get (0);
                            }else {
                                // 若位置35名称不一致,则位置45肯定一致,位置6取位置3名称;
                                List<Fushi> count6_3 = count6.stream ().filter (a -> fushiList.get (2).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                fushi6 = count6_3.get (0);
                            }
                        }
                    }else {
                        // 若位置12名称不一致,则判断位置34名称是否一致
                        if (wz34){
                            // 若位置34名称一致,则判断位置15名称是否一致
                            if (wz15){
                                // 若位置15名称一致,则位置6取位置2名称;
                                List<Fushi> count6_4 = count6.stream ().filter (a -> fushiList.get (3).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                fushi6 = count6_4.get (0);
                            }else {
                                // 若位置15名称不一致,则位置25肯定一致,位置6取位置1名称;
                                List<Fushi> count6_5 = count6.stream ().filter (a -> fushiList.get (0).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                fushi6 = count6_5.get (0);
                            }
                        }else {
                            // 若位置34名称不一致,则判断位置13名称是否一致
                            if (wz13){
                                // 若位置13名称一致,则判断位置24名称是否一致
                                if (wz24){
                                    // 若位置24名称一致,位置6取位置5名称;
                                }else {
                                    // 若位置24名称不一致,则判断位置25名称是否一致
                                    if (wz25){
                                        // 若位置25名称一致,位置6取位置4名称;
                                        List<Fushi> count6_6 = count6.stream ().filter (a -> fushiList.get (3).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                        fushi6 = count6_6.get (0);
                                    }else {
                                        // 若位置25名称不一致,则位置45肯定一致,位置6取位置2名称
                                        List<Fushi> count6_7 = count6.stream ().filter (a -> fushiList.get (1).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                        fushi6 = count6_7.get (0);
                                    }
                                }
                            }else {
                                // 若位置13名称不一致,则判断位置14名称是否一致
                                if (wz14){
                                    // 若位置14名称一致,则判断位置23名称是否一致
                                    if (wz23){
                                        // 若位置23名称一致,位置6取位置5名称;
                                    }else {
                                        // 若位置23名称不一致,则判断位置25名称是否一致
                                        if (wz25) {
                                            // 若位置25名称一致,位置6取位置3名称;
                                            List<Fushi> count6_7 = count6.stream ().filter (a -> fushiList.get (2).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                            fushi6 = count6_7.get (0);
                                        }else {
                                            // 若位置25名称不一致,则位置35肯定一致,位置6取位置2名称
                                            List<Fushi> count6_8 = count6.stream ().filter (a -> fushiList.get (1).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                            fushi6 = count6_8.get (0);
                                        }
                                    }
                                }else {
                                    // 若位置14名称不一致,则判断位置15名称是否一致
                                    if (wz15){
                                        // 若位置15名称一致,则判断位置23名称是否一致
                                        if (wz23){
                                            // 若位置23名称一致,位置6取位置4名称;
                                            List<Fushi> count6_9 = count6.stream ().filter (a -> fushiList.get (3).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                            fushi6 = count6_9.get (0);
                                        }else {
                                            // 若位置23名称不一致,则判断位置24名称是否一致
                                            if (wz24){
                                                // 若位置24名称一致,位置6取位置3名称;
                                                List<Fushi> count6_10 = count6.stream ().filter (a -> fushiList.get (2).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                                fushi6 = count6_10.get (0);
                                            }else {
                                                // 若位置24名称不一致,冲突
                                            }
                                        }
                                    }else {
                                        // 若位置15名称不一致,位置6取位置1名称;
                                        List<Fushi> count6_11 = count6.stream ().filter (a -> fushiList.get (0).getName ().equals (a.getName ())).collect (Collectors.toList ());
                                        fushi6 = count6_11.get (0);
                                    }
                                }
                            }
                        }
                    }
                    count6.remove (fushi6);
                    fushiList.add(fushi6);
                    zhFushiList.add(fushiList);
                }
            }
        }
        System.out.println (zhFushiList.size ());
        zhFushiList.forEach (a -> {
            a.forEach (b -> System.out.println (b));
            System.out.println ("------------");
        });
    }
}
