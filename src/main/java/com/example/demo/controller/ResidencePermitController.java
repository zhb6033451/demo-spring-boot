package com.example.demo.controller;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class ResidencePermitController  {

    @GetMapping("/downloadResidencePermitInfo")
    public ResponseEntity<byte[]> downloadResidencePermitInfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 创建工作簿
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("居住证信息");

            // 填充Excel数据
            fillExcelSheet(sheet);

            // 创建临时目录
            Path tempDirectory = Files.createTempDirectory("居住证办理资料");

            // 保存Excel文件到临时目录
            String excelFileName = tempDirectory.resolve("居住证信息.xlsx").toString();
            try (FileOutputStream outputStream = new FileOutputStream (excelFileName)) {
                workbook.write(outputStream);
            }
            workbook.close();

            // 下载图片并保存到文件夹B中
            Path studentFolder = Files.createDirectory(tempDirectory.resolve("第1个学生某某某的信息"));
            downloadAndSaveImage("https://hldc-test.obs.cn-east-3.myhuaweicloud.com/simsbff/20240411/image/file0000078530.png?x-image-process=image/resize,p_25",
            studentFolder.resolve("image1.jpg").toString());
            downloadAndSaveImage("https://hldc-test.obs.cn-east-3.myhuaweicloud.com/simsbff/20240411/image/file0000078531.png?x-image-process=image/resize,p_25",
            studentFolder.resolve("image2.jpg").toString());
            // ImageUtil.resizeImage ("https://hldc-test.obs.cn-east-3.myhuaweicloud.com/simsbff/20240411/image/file0000078530.png",
            //         studentFolder.resolve("image1.jpg").toString(),640, 0, 0.3f);
            // ImageUtil.resizeImage ("https://hldc-test.obs.cn-east-3.myhuaweicloud.com/simsbff/20240411/image/file0000078531.png",
            //         studentFolder.resolve("image2.jpg").toString(),640, 0, 0.3f);
            // downloadCompressAndSaveImage ("https://hldc-test.obs.cn-east-3.myhuaweicloud.com/simsbff/20240411/image/file0000078530.png",
            //         studentFolder.resolve("image1.jpg").toString(),1f,0.2f);
            // downloadCompressAndSaveImage ("https://hldc-test.obs.cn-east-3.myhuaweicloud.com/simsbff/20240411/image/file0000078531.png",
            //         studentFolder.resolve("image2.jpg").toString(),1f,0.2f);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (ZipOutputStream zos = new ZipOutputStream(baos)) {
                // 从"居住证办理资料/"开始，表示所有条目都放在这个顶级文件夹下
                zipFile(tempDirectory, "居住证办理资料/", zos);
                // 确保在此处正确处理ZipOutputStream
            }

            // 设置响应头
            HttpHeaders headers = new HttpHeaders();
            String userAgent = request.getHeader("USER-AGENT");
            String fileName = "居住证办理资料.zip";
            String filename;
            if (org.apache.commons.lang3.StringUtils.contains (userAgent, "MSIE")) {
                filename = URLEncoder.encode (fileName, "UTF8");
            } else if (org.apache.commons.lang3.StringUtils.contains (userAgent, "Mozilla")) {
                filename = new String (fileName.getBytes (StandardCharsets.UTF_8), "ISO8859-1");
            } else {
                filename = URLEncoder.encode (fileName, "UTF8");
            }
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", filename);

            return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 填充Excel示例数据
    private void fillExcelSheet(XSSFSheet sheet) {
        // 这里填充Excel的具体逻辑，如创建行、单元格等，并填充数据
        // 示例：
        Object[][] bookData = {
                {"序号", "招生性质", "学校", "学部", "年级", "学生姓名", "学生证件号", "办理居住证姓名", "办理居住证身份证号码", "办理居住证联系方式", "备注"},
                {1, "示例性质", "示例学校", "示例学部", "1", "某某某", "123456789", "某某某", "987654321", "13888888888", "无"},
                // 更多数据...
        };

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow (++rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell (++columnCount);
                if (field instanceof String) {
                    cell.setCellValue ((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue ((Integer) field);
                }
            }
        }
    }

    private void downloadAndSaveImage(String imageUrl, String destinationFile) throws Exception {
        RestTemplate restTemplate = new RestTemplate ();
        byte[] imageBytes = restTemplate.getForObject(imageUrl, byte[].class);
        try (FileOutputStream fos = new FileOutputStream(destinationFile)) {
            fos.write(imageBytes);
        }
    }

    public void downloadCompressAndSaveImage (String imageUrl, String destinationFile,float scale,float quality) throws IOException {
        RestTemplate restTemplate = new RestTemplate ();
        byte[] imageBytes = restTemplate.getForObject (imageUrl, byte[].class);
        BufferedImage inputImage = null;
        if (imageBytes != null) {
            inputImage = ImageIO.read (new ByteArrayInputStream (imageBytes));
        }
        Thumbnails.of(inputImage)
                //图片大小（长宽）压缩比例 从0-1，1表示原图
                .scale(scale)
                //图片质量压缩比例 从0-1，越接近1质量越好
                .outputQuality(quality)
                .toFile(destinationFile);
    }

    private void zipFile(Path fileToZip, String zipEntryName, ZipOutputStream zipOut) throws IOException {
        if (Files.isDirectory (fileToZip)) {
            // 如果是目录，确保目录名以"/"结尾
            if (!zipEntryName.endsWith ("/")) {
                zipEntryName += "/";
            }
            String finalZipEntryName = zipEntryName;
            Files.list (fileToZip).forEach (path -> {
                try {
                    // 递归添加文件夹内容，调整条目名称以反映期望的结构
                    zipFile (path, finalZipEntryName + path.getFileName ().toString (), zipOut);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            });
        } else {
            // 如果是文件，直接添加
            try (FileInputStream fis = new FileInputStream (fileToZip.toFile ())) {
                ZipEntry zipEntry = new ZipEntry (zipEntryName);
                zipOut.putNextEntry (zipEntry);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read (bytes)) >= 0) {
                    zipOut.write (bytes, 0, length);
                }
                zipOut.closeEntry ();
            }
        }
    }
}
