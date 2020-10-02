package com.test.tank;

import com.test.tank.constant.Constants;
import com.test.tank.constant.Direction;
import com.test.tank.i.IRectangle;
import com.test.tank.util.PropertyManager;
import com.test.tank.util.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import static com.test.tank.constant.Constants.FRAME_HEIGHT;
import static com.test.tank.constant.Constants.FRAME_WIDTH;

public class Tank implements IRectangle {
    private Frame frame;
    int x=200,y=200;
    private Rectangle rectangle = new Rectangle();

    int width= Constants.TANK_SIZE,height=Constants.TANK_SIZE;

    Direction direction = Direction.DOWN;
    boolean moving = false;
    boolean living = true;
    static final int SPEED= PropertyManager.getInteger("tankSpeed");

    private ArrayList<Bullet> bulletList = new ArrayList<>();

    public Tank(Frame frame) {
        this.frame = frame;
    }

    public BufferedImage getImage(Direction direction){
        switch (direction){
            case LEFT: return ResourceManager.tankL;
            case UP: return ResourceManager.tankU;
            case RIGHT: return ResourceManager.tankR;
            case DOWN: return ResourceManager.tankD;
            default:break;
        }
        return null;
    }

    public void paint(Graphics g) throws IOException {
        if(!living) return;

        move();
        g.setColor(Color.RED);
        g.drawImage(getImage(direction), x, y, width, height, frame);

        painBullet(g);
    }

    private void painBullet(Graphics g){
        bulletList.removeIf(bullet -> !bullet.isLiving());

        for (Bullet bullet : bulletList) {
            bullet.paint(g);
        }
    }

    private void move() {
        if(!moving){return;}

        new Thread(()->new Audio("audio/tank_move.wav").play()).start();
        switch (direction){
            case LEFT:
                if(x - SPEED > 0) x-=SPEED;
                break;
            case UP:
                if(y - SPEED > 0)y-=SPEED;
                break;
            case RIGHT:
                if(x + SPEED +this.width <= FRAME_WIDTH)x+=SPEED;
                break;
            case DOWN:
                if(y + SPEED +this.height <= FRAME_HEIGHT)y+=SPEED;
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

    public ArrayList<Bullet> getBulletList() {
        return bulletList;
    }

    public void setBulletList(ArrayList<Bullet> bulletList) {
        this.bulletList = bulletList;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Frame getFrame() {
        return frame;
    }

    public void recycle(){
        this.height = 0;
        this.width = 0;
    }

    public void resurgence(){
        this.height = Constants.TANK_SIZE;
        this.width = Constants.TANK_SIZE;
    }

    @Override
    public Rectangle getRectangle() {
        rectangle.x = x;
        rectangle.y = y;
        rectangle.width = width;
        rectangle.height = height;
        return rectangle;
    }

    public void fire(){
        getBulletList().add(new Bullet(getX(), getY(), getDirection()));
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }
}
