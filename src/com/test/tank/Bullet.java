package com.test.tank;

import com.test.tank.constant.Dir;
import com.test.tank.util.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 子弹类
 *
 * @author: liujinliang
 * @create: 2020-09-26 21:12
 **/
public class Bullet {
    int x=200,y=200;
    int width =10, height =10;
    boolean living = true;
    Dir dir;
    private static final int SPEED= 10;
    int tankX,tankY;

    public Bullet(int x, int y, Dir dir) {
        this.tankX = x;
        this.tankY = y;
        this.x = x + 50;
        this.y = y + 50;
        this.dir = dir;
        this.width = 10;
        this.height = 10;
    }

    public BufferedImage getImage(Dir dir){
        switch (dir){
            case LEFT: return ResourceManager.bulletL;
            case UP: return ResourceManager.bulletU;
            case RIGHT: return ResourceManager.bulletR;
            case DOWN: return ResourceManager.bulletD;
            default:break;
        }
        return null;
    }

    public void paint(Graphics g) {
        if(!living) return;
        move();
        g.drawImage(getImage(dir), x,y, width, height, null);
    }

    /**
     * 这里的50是tank的长度和宽度
     */
    private void move() {
        switch (dir){
            case LEFT:
                y = tankY + 50 - height /2;
                x = x - SPEED;
                break;
            case UP:
                x = tankX + 50 - width /2;
                y-=SPEED;
                break;
            case RIGHT:
                y = tankY + 50 - height /2;
                x+=SPEED;
                break;
            case DOWN:
                x = tankX + 50 - width /2;
                y+=SPEED;
                break;
            default:break;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public void collisionWith(Tank tank){
        Rectangle rectangleBullet = new Rectangle(this.x, this.y, width, height);
        Rectangle rectangleTank = new Rectangle(tank.x, tank.y, Tank.TANK_WIDTH, Tank.TANK_HEIGHT);
        if(rectangleBullet.intersects(rectangleTank)){
            tank.setLiving(false);
            this.setLiving(false);
            this.x =0;
            this.y=0;
            this.width = 0;
            this.height = 0;
        }
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