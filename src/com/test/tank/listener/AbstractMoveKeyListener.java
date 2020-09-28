package com.test.tank.listener;

import com.test.tank.constant.Dir;
import com.test.tank.Tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 方向键监听器
 *
 * @author: liujinliang
 * @create: 2020-09-28 22:08
 **/
public abstract class AbstractMoveKeyListener extends KeyAdapter {
    Tank tank;
    boolean bL = false;
    boolean bU = false;
    boolean bR = false;
    boolean bD = false;

    public AbstractMoveKeyListener(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        listenDirKey(key);

        if (bL || bU || bR || bD) {
            tank.setMoving(true);
        }
        else {
            tank.setMoving(false);
        }
        setMainTankDir();
        tank.getFrame().repaint();
    }

    abstract void listenDirKey(int key);

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
            default:
                break;
        }
    }

    private void setMainTankDir() {
        if (bL)
            tank.setDir(Dir.LEFT);
        if (bU)
            tank.setDir(Dir.UP);
        if (bR)
            tank.setDir(Dir.RIGHT);
        if (bD)
            tank.setDir(Dir.DOWN);
    }

}
