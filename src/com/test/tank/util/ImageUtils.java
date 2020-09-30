package com.test.tank.util;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 图片工具类
 *
 * @author: liujinliang
 * @create: 2020-09-30 13:03
 **/
public class ImageUtils {

    public static InputStream rotateImg(BufferedImage image, int degree) throws IOException {
        int iw = image.getWidth();//原始图象的宽度
        int ih = image.getHeight();//原始图象的高度
        int w = 0;
        int h = 0;
        int x = 0;
        int y = 0;
        degree = degree % 360;
        if (degree < 0)
            degree = 360 + degree;//将角度转换到0-360度之间
        double ang = Math.toRadians(degree);//将角度转为弧度

        /**
         *确定旋转后的图象的高度和宽度
         */

        if (degree == 180 || degree == 0 || degree == 360) {
            w = iw;
            h = ih;
        }
        else if (degree == 90 || degree == 270) {
            w = ih;
            h = iw;
        }
        else {
            int d = iw + ih;
            w = (int) (d * Math.abs(Math.cos(ang)));
            h = (int) (d * Math.abs(Math.sin(ang)));
        }

        x = (w / 2) - (iw / 2);//确定原点坐标
        y = (h / 2) - (ih / 2);
        BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
        Graphics2D gs = (Graphics2D) rotatedImage.getGraphics();
        rotatedImage = gs.getDeviceConfiguration().createCompatibleImage(w, h, Transparency.TRANSLUCENT);

        AffineTransform at = new AffineTransform();
        at.rotate(ang, w / 2, h / 2);//旋转图象
        at.translate(x, y);
        AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
        op.filter(image, rotatedImage);
        image = rotatedImage;

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ImageOutputStream iamgeOut = ImageIO.createImageOutputStream(byteOut);

        ImageIO.write(image, "png", iamgeOut);
        InputStream inputStream = new ByteArrayInputStream(byteOut.toByteArray());

        return inputStream;
    }
}
