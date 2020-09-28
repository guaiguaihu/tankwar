package com.test.tank;

import java.io.IOException;

public class T {
    public static void main(String[] args) throws InterruptedException, IOException {
        TankFrame tf = new TankFrame();

        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
