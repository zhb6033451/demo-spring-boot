package com.example.demo.utils;

import com.example.demo.pojo.Pojo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class BenUtil {
    private static final Logger log = LoggerFactory.getLogger(BenUtil.class);
    /**
     * @param list 切割list , n份
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

    // 压缩
    public static String compress(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        } else {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            GZIPOutputStream gzip = null;

            String var4;
            try {
                gzip = new GZIPOutputStream(out);
                gzip.write(str.getBytes());
                return (new BASE64Encoder ()).encode(out.toByteArray());
            } catch (Exception var14) {
                log.error(var14.getMessage(), var14);
                var4 = str;
            } finally {
                if (gzip != null) {
                    try {
                        gzip.close();
                    } catch (Exception var13) {
                        log.error(var13.getMessage(), var13);
                    }
                }

            }

            return var4;
        }
    }

    // 解压
    public static String uncompress(String compressedStr) {
        if (StringUtils.isBlank(compressedStr)) {
            return compressedStr;
        } else {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = null;
            GZIPInputStream ginzip = null;

            String var7;
            try {
                byte[] compressed = (new BASE64Decoder ()).decodeBuffer(compressedStr);
                in = new ByteArrayInputStream (compressed);
                ginzip = new GZIPInputStream (in);
                byte[] buffer = new byte[1024];

                int offset;
                while((offset = ginzip.read(buffer)) != -1) {
                    out.write(buffer, 0, offset);
                }

                String decompressed = out.toString();
                return decompressed;
            } catch (Exception var25) {
                log.error(var25.getMessage(), var25);
                var7 = compressedStr;
            } finally {
                if (ginzip != null) {
                    try {
                        ginzip.close();
                    } catch (IOException var24) {
                        log.error(var24.getMessage(), var24);
                    }
                }

                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException var23) {
                        log.error(var23.getMessage(), var23);
                    }
                }

                try {
                    out.close();
                } catch (IOException var22) {
                    log.error(var22.getMessage(), var22);
                }

            }

            return var7;
        }
    }

    //关键代码 运行序列化和反序列化  进行深度拷贝
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream ();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

}
