package com.test.tank;

import com.test.tank.constant.Direction;
import com.test.tank.i.IRectangle;
import com.test.tank.util.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import static com.test.tank.TankFrame.FRAME_HEIGHT;
import static com.test.tank.TankFrame.FRAME_WIDTH;

public class Tank implements IRectangle {
    private Frame frame;
    private BufferedImage image;
    int x=200,y=200;
    int width=TANK_WIDTH,height=TANK_HEIGHT;

    Direction direction = Direction.DOWN;
    boolean moving = false;
    boolean dirKey = true;
    boolean living = true;
    private static final int SPEED= 10;
    public static final int TANK_WIDTH= 100,TANK_HEIGHT= 100;

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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean isDirKey() {
        return dirKey;
    }

    public void setDirKey(boolean dirKey) {
        this.dirKey = dirKey;
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

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public void recycle(){
        this.setWidth(0);
        this.setHeight(0);
    }

    public void resurgence(){
        this.setWidth(TANK_WIDTH);
        this.setHeight(TANK_HEIGHT);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x,y,width,height);
    }
}
