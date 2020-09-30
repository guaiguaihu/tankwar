package com.test.tank;

import com.test.tank.util.ImageUtils;
import com.test.tank.util.ResourceManager;
import com.test.tank.util.ThreadUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class T {
    public static void main(String[] args) throws InterruptedException, IOException {
        TankFrame tf = new TankFrame();
        new Thread(()->new Audio("audio/war1.wav").play()).start();

        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
