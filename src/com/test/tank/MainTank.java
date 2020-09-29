package com.test.tank;


import com.test.tank.constant.Constants;
import com.test.tank.constant.Direction;
import com.test.tank.util.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import static com.test.tank.constant.Constants.FRAME_HEIGHT;
import static com.test.tank.constant.Constants.FRAME_WIDTH;

public class MainTank extends Tank {
    public MainTank(Frame frame) {
        super(frame);
        setX(FRAME_WIDTH- Constants.TANK_SIZE);
        setY(FRAME_HEIGHT/2);
    }

    public BufferedImage getImage(Direction direction){
        switch (direction){
            case LEFT: return ResourceManager.planeL;
            case UP: return ResourceManager.planeU;
            case RIGHT: return ResourceManager.planeR;
            case DOWN: return ResourceManager.planeD;
            default:break;
        }
        return null;
    }
}
