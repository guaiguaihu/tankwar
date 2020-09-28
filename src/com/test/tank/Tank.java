package com.test.tank;

import com.test.tank.constant.Dir;
import com.test.tank.util.ResourceManager;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import static com.test.tank.TankFrame.FRAME_HEIGHT;
import static com.test.tank.TankFrame.FRAME_WIDTH;

public class Tank {
    private Frame frame;
    private String image;
    int x=200,y=200;
    Dir dir = Dir.DOWN;
    boolean moving = false;
    boolean dirKey = true;
    boolean living = true;
    private static final int SPEED= 10;
    public static final int TANK_WIDTH= 100,TANK_HEIGHT= 100;

    private ArrayList<Bullet> bulletList = new ArrayList<>();

    public BufferedImage getImage(Dir dir){
        switch (dir){
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
        g.drawImage(getImage(dir), x, y, TANK_WIDTH, TANK_HEIGHT, frame);

        // 画子弹
        for (Bullet bullet : bulletList) {
            bullet.paint(g);
        }
    }

    private void move() {
        if(!moving){return;}
        switch (dir){
            case LEFT:
                if(x - SPEED > 0) x-=SPEED;
                break;
            case UP:
                if(y - SPEED > 0)y-=SPEED;
                break;
            case RIGHT:
                if(x + SPEED +Tank.TANK_WIDTH <= FRAME_WIDTH)x+=SPEED;
                break;
            case DOWN:
                if(y + SPEED +Tank.TANK_HEIGHT <= FRAME_HEIGHT)y+=SPEED;
                break;
            default:break;
        }
    }

    public Tank(Frame frame) {
        this.frame = frame;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public class TankKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(isDirKey()){
                listenDirKey(key);
            } else {
                listenKey(key);
            }


            if(bL || bU || bR || bD){
                moving = true;
            } else {
                moving = false;
            }
            setMainTandkDir();
            frame.repaint();
        }

        private void listenDirKey(int key) {
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;
                case KeyEvent.VK_CONTROL:
                    bulletList.add(new Bullet(x,y,dir));
                    break;
                default:break;
            }
        }

        private void listenKey(int key){
            switch (key){
                case KeyEvent.VK_A:
                    bL=true;
                    break;
                case KeyEvent.VK_W:
                    bU=true;
                    break;
                case KeyEvent.VK_D:
                    bR=true;
                    break;
                case KeyEvent.VK_S:
                    bD=true;
                    break;
                case KeyEvent.VK_F:
                    bulletList.add(new Bullet(x,y,dir));
                    break;
                default:break;
            }
        }

        private void setMainTandkDir() {
            if(bL) dir = Dir.LEFT;
            if(bU) dir = Dir.UP;
            if(bR) dir = Dir.RIGHT;
            if(bD) dir = Dir.DOWN;

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if(dirKey){
                switch (key){
                    case KeyEvent.VK_LEFT:
                        bL=false;
                        break;
                    case KeyEvent.VK_UP:
                        bU=false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        bR=false;
                        break;
                    case KeyEvent.VK_DOWN:
                        bD=false;
                        break;
                    default:break;
                }
            } else {
                switch (key){
                    case KeyEvent.VK_A:
                        bL=false;
                        break;
                    case KeyEvent.VK_W:
                        bU=false;
                        break;
                    case KeyEvent.VK_D:
                        bR=false;
                        break;
                    case KeyEvent.VK_S:
                        bD=false;
                        break;
                    default:break;
                }
            }

        }
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

    public void setFrame(Frame frame) {
        this.frame = frame;
    }
}
