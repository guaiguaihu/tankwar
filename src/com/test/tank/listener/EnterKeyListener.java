package com.test.tank.listener;

import com.test.tank.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * 回车监控
 *
 * @author: liujinliang
 * @create: 2020-09-28 20:44
 **/
public class EnterKeyListener extends KeyAdapter {
    private List<Tank> tanks;
    private Frame frame;

    public EnterKeyListener(Frame frame, List<Tank> tanks) {
        this.tanks = tanks;
        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(KeyEvent.VK_ENTER != keyCode){
            return;
        }

        for (Tank tank : tanks) {
            if(!tank.isLiving()){
                tank.setLiving(true);
                tank.resurgence();
            }
        }
        frame.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
    }
}
