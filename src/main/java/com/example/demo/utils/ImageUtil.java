package com.example.demo.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageUtil {

    private static final RestTemplate restTemplate = new RestTemplate ();

    public static void downloadCompressAndSaveImage (String inputImagePath, String outputImagePath) throws IOException {
        byte[] imageBytes = restTemplate.getForObject (inputImagePath, byte[].class);
        BufferedImage inputImage = ImageIO.read (new ByteArrayInputStream (imageBytes));
        Thumbnails.of(inputImage)
                .scale(0.3f)
                .outputQuality(0.3f)
                .toFile(outputImagePath);
    }

    public static void resizeImage(String inputImagePath, String outputImagePath, int targetWidth, int targetHeight, float quality) throws IOException {
        // 读取原始图片
        byte[] imageBytes = restTemplate.getForObject (inputImagePath, byte[].class);
        BufferedImage inputImage = ImageIO.read (new ByteArrayInputStream (imageBytes));

        // 计算压缩比例
        double aspectRatio = (double) inputImage.getWidth() / inputImage.getHeight();
        if (targetWidth <= 0) {
            targetWidth = (int) (targetHeight * aspectRatio);
        }
        if (targetHeight <= 0) {
            targetHeight = (int) (targetWidth / aspectRatio);
        }

        // 创建输出图片对象
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = outputImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(inputImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();

        // 获取图片格式
        String formatName = inputImagePath.substring(inputImagePath.lastIndexOf(".") + 1);

        // 输出到文件
        File outputFile = new File(outputImagePath);
        ImageIO.write(outputImage, formatName, outputFile);
    }


}
