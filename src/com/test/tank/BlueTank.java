package com.test.tank;

import com.test.tank.constant.Direction;
import com.test.tank.util.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.test.tank.TankFrame.FRAME_HEIGHT;

public class BlueTank extends Tank {
    public BlueTank(Frame frame) {
        super(frame);
        setX(0);
        setY(FRAME_HEIGHT/2);
        setDirKey(false);
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
}
