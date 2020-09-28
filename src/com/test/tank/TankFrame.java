package com.test.tank;

import com.test.tank.listener.AlphabetMoveKeyListener;
import com.test.tank.listener.DirectionMoveKeyListener;
import com.test.tank.listener.EnterKeyListener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Arrays;

public class TankFrame extends Frame {
    MainTank mainTank = new MainTank(this, "D:\\workspace\\test\\planeUP.jpg");
    BlueTank blueTank = new BlueTank(this, "D:\\workspace\\test\\tank.jpg");
    public final static int FRAME_WIDTH = 800, FRAME_HEIGHT = 600;

    public TankFrame() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setVisible(true);
        setTitle("tank war");
        this.addKeyListener(new DirectionMoveKeyListener(mainTank));
        this.addKeyListener(new AlphabetMoveKeyListener(blueTank));
        this.addKeyListener(new EnterKeyListener(this, Arrays.asList(mainTank, blueTank)));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        try {
            for (Bullet bullet : mainTank.getBulletList()) {
                bullet.collisionWith(blueTank);
            }
            for (Bullet bullet : blueTank.getBulletList()) {
                bullet.collisionWith(mainTank);
            }

            mainTank.paint(g);
            blueTank.paint(g);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(FRAME_WIDTH, FRAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
