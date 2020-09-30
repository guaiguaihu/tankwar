package com.test.tank;

import com.test.tank.constant.Constants;
import com.test.tank.constant.Direction;
import com.test.tank.i.IRectangle;
import com.test.tank.util.ResourceManager;
import com.test.tank.util.ThreadUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 子弹类
 *
 * @author: liujinliang
 * @create: 2020-09-26 21:12
 **/
public class Bullet implements IRectangle {
    int x=200,y=200;
    int width =10, height =10;
    boolean living = true;
    Direction direction;
    private static final int SPEED= 30;
    int tankX,tankY;

    public Bullet(int x, int y, Direction direction) {
        this.tankX = x;
        this.tankY = y;
        this.x = x + Constants.TANK_SIZE;
        this.y = y + Constants.TANK_SIZE;
        this.direction = direction;
        this.width = 10;
        this.height = 10;
    }

    public BufferedImage getImage(Direction direction){
        switch (direction){
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
        g.drawImage(getImage(direction), x,y, width, height, null);
    }

    /**
     * 这里的50是tank的长度和宽度
     */
    private void move() {
        switch (direction){
            case LEFT:
                y = tankY + Constants.TANK_SIZE/2 - height /2;
                x = x - SPEED;
                break;
            case UP:
                x = tankX + Constants.TANK_SIZE/2 - width /2;
                y-=SPEED;
                break;
            case RIGHT:
                y = tankY + Constants.TANK_SIZE /2- height /2;
                x+=SPEED;
                break;
            case DOWN:
                x = tankX + Constants.TANK_SIZE/2 - width /2;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public void collisionWith(Tank tank){
        if(this.getRectangle().intersects(tank.getRectangle())){
            tank.setLiving(false);
            this.setLiving(false);
            new Bomb(tank, this).paint();
            ThreadUtils.sleep(500);
            tank.recycle();
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

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x,y,width,height);
    }
}
