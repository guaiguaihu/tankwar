package com.test.tank.listener;

import com.test.tank.Bullet;
import com.test.tank.Tank;

import java.awt.event.KeyEvent;

/**
 * 方向键监听器
 *
 * @author: liujinliang
 * @create: 2020-09-28 22:08
 **/
public class DirectionMoveKeyListener extends AbstractMoveKeyListener {
    public DirectionMoveKeyListener(Tank tank) {
        super(tank);
    }

    @Override
    void listenDirKey(int key) {
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
            case KeyEvent.VK_CONTROL:
                tank.getBulletList().add(new Bullet(tank.getX(), tank.getY(), tank.getDirection()));
                break;
            default:
                break;
        }
    }

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
}
