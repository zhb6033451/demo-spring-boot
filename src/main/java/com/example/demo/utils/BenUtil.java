package com.example.demo.utils;

import com.example.demo.pojo.Pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BenUtil {
    /**
     * @param list
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> list, int n) {
        List<List<T>> result = new ArrayList<List<T>> ();
        int remaider = list.size () % n;  //(先计算出余数)
        int number = list.size () / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remaider > 0) {
                value = list.subList (i * number + offset, (i + 1) * number + offset + 1);
                remaider--;
                offset++;
            } else {
                value = list.subList (i * number + offset, (i + 1) * number + offset);
            }
            result.add (value);
        }
        return result;
    }

    //平时排序可使用其中一种，下面是综合两个条件排序
    public static void setListOrder(List<Integer> orderRegulation, List<Pojo> targetList) {

        //按照pojo的a来排序
        Collections.sort(targetList, ((o1, o2) -> {
            int io1 = orderRegulation.indexOf(o1.getA ());
            int io2 = orderRegulation.indexOf(o2.getA ());

            if (io1 != -1) {
                io1 = targetList.size() - io1;
            }
            if (io2 != -1) {
                io2 = targetList.size() - io2;
            }

            return io2 - io1;
        }));
    }

}
