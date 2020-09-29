package com.test.tank;

import com.test.tank.util.ResourceManager;

import java.awt.*;

/**
 * 炸弹类
 *
 * @author: liujinliang
 * @create: 2020-09-29 06:30
 **/
public class Bomb {
    private int x = 400,y=300;
    private int width = 100,height=100;
    private Bullet bullet;
    private Frame frame;

    public Bomb(Frame frame) {
        this.frame = frame;
    }

    public Bomb(Frame frame, Bullet bullet) {
        this.bullet = bullet;
        this.frame = frame;
        this.x = bullet.getX();
        this.y = bullet.getY();
        this.setWidth(100);
        this.setHeight(100);
    }

    public void paint(){
        switch (bullet.getDirection()){
            case LEFT: y-=height/2;x-=width;break;
            case RIGHT:y-=height/2;break;
            case UP:y-=height;x-=width/2;break;
            case DOWN:x-=width/2;break;
            default:break;
        }
        frame.getGraphics().drawImage(ResourceManager.bomb01, x,y,width,height, null);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
