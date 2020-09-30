package com.test.tank.util;

import com.sun.imageio.plugins.common.ImageUtil;
import com.test.tank.Audio;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * 资源管理器
 *
 * @author: liujinliang
 * @create: 2020-09-28 06:50
 **/
public class ResourceManager {
    public static BufferedImage tankL,tankU,tankR,tankD,bulletL,bulletU,bulletR,bulletD, bomb01, planeL,planeU,planeR,planeD;
    public static Audio explode,tankFire,tankMove,war;

    static {
        try {
            tankU = loadBufferedImage("images/tankU.gif");

            tankL = ImageIO.read(ImageUtils.rotateImg(tankU, 270));
            tankR = ImageIO.read(ImageUtils.rotateImg(tankU, 90));
            tankD = ImageIO.read(ImageUtils.rotateImg(tankU, 180));

            bulletU = loadBufferedImage("images/bulletU.gif");
            bulletL = ImageIO.read(ImageUtils.rotateImg(bulletU, 270));
            bulletR = ImageIO.read(ImageUtils.rotateImg(bulletU, 90));
            bulletD = ImageIO.read(ImageUtils.rotateImg(bulletU, 180));

            bomb01 = loadBufferedImage("images/bomb01.gif");

            planeU = loadBufferedImage("images/planeU.gif");
            planeL = ImageIO.read(ImageUtils.rotateImg(planeU, 270));
            planeR = ImageIO.read(ImageUtils.rotateImg(planeU, 90));
            planeD = ImageIO.read(ImageUtils.rotateImg(planeU, 180));

            explode = new Audio("audio/explode.wav");
            tankFire = new Audio("audio/tank_fire.wav");
            tankMove = new Audio("audio/tank_move.wav");
            war = new Audio("audio/war1.wav");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage loadBufferedImage(String path) throws IOException {
        return ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream(path)));
    }
}
