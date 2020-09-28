package com.test.tank.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 资源管理器
 *
 * @author: liujinliang
 * @create: 2020-09-28 06:50
 **/
public class ResourceManager {
    public static BufferedImage tankL,tankU,tankR,tankD,bulletL,bulletU,bulletR,bulletD;

    static {
        try {
            ClassLoader classLoader = ResourceManager.class.getClassLoader();
            tankL = ImageIO.read(classLoader.getResourceAsStream("images/tankL.gif"));
            tankU = ImageIO.read(classLoader.getResourceAsStream("images/tankU.gif"));
            tankR = ImageIO.read(classLoader.getResourceAsStream("images/tankR.gif"));
            tankD = ImageIO.read(classLoader.getResourceAsStream("images/tankD.gif"));

            bulletL = ImageIO.read(classLoader.getResourceAsStream("images/bulletL.gif"));
            bulletU = ImageIO.read(classLoader.getResourceAsStream("images/bulletU.gif"));
            bulletR = ImageIO.read(classLoader.getResourceAsStream("images/bulletR.gif"));
            bulletD = ImageIO.read(classLoader.getResourceAsStream("images/bulletD.gif"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
