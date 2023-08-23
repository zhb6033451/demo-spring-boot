package com.example.demo.controller;

import cn.hutool.core.util.URLUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class DownloadController {

    @GetMapping("/download/{fileName}")
    public void downloadPattern(@PathVariable("fileName") String fileName, HttpServletRequest request,HttpServletResponse response){
        System.out.println("开始下载文件..... fileName:  "+fileName);
        ClassPathResource resource = new ClassPathResource ("\\model\\"+fileName);
        try {
            //获取文件输入流
            InputStream in = resource.getInputStream();
            //下载文件
            // downFile(fileName,response,in);
            downDeviceManagementTemplate(in,fileName,request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 下载文件
     * @param fileName 下载文件名称
     * @param response 响应
     * @throws IOException 异常
     */
    public static void downFile(String fileName,HttpServletResponse response, InputStream in) throws IOException {
        //输出流自动关闭，java1.7新特性
        try(OutputStream os = response.getOutputStream()) {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentType("application/octet-stream; charset=UTF-8");
            byte[] b = new byte[in.available()];
            in.read(b);
            os.write(b);
            os.flush();
        } catch (Exception e) {
            System.out.println("fileName=" + fileName);
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public void downDeviceManagementTemplate(InputStream inputStream,String fileName,
                                             HttpServletRequest req, HttpServletResponse res) throws IOException {
        String path = "model\\"+fileName;
        // String fileName = path.substring(path.lastIndexOf("/") + 1);
        // 读取服务器端模板文件
        // InputStream inputStream = FileUtil.getInputStream(path);
        // 转为POI的Workbook输出流，这样下载后 打开不报错，直接输出  流 的话，打开excel可能提示错误
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        String userAgent = req.getHeader("User-Agent");
        // 针对IE或者以IE为内核的浏览器：
        if(userAgent.contains("MSIE")||userAgent.contains("Trident")) {
            fileName = URLUtil.encode(fileName);
        } else {
            // 非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
        }
        res.setHeader("Content-disposition", "attachment; filename=" + fileName);
        res.setContentType("application/vnd.ms-excel; charset=utf-8");
        res.setCharacterEncoding("UTF-8");
        // 将流中内容写出去
        OutputStream outputStream = res.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
