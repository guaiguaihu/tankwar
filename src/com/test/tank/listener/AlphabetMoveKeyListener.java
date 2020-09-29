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
public class AlphabetMoveKeyListener extends AbstractMoveKeyListener {
    public AlphabetMoveKeyListener(Tank tank) {
        super(tank);
    }

    @Override
    void listenDirKey(int key) {
        switch (key) {
            case KeyEvent.VK_A:
                bL = true;
                break;
            case KeyEvent.VK_W:
                bU = true;
                break;
            case KeyEvent.VK_D:
                bR = true;
                break;
            case KeyEvent.VK_S:
                bD = true;
                break;
            case KeyEvent.VK_F:
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
            case KeyEvent.VK_A:
                bL = false;
                break;
            case KeyEvent.VK_W:
                bU = false;
                break;
            case KeyEvent.VK_D:
                bR = false;
                break;
            case KeyEvent.VK_S:
                bD = false;
                break;
            default:
                break;
        }
    }
}
