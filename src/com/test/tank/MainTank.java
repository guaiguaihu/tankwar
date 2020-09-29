package com.test.tank;


import com.test.tank.constant.Direction;
import com.test.tank.util.ResourceManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.test.tank.TankFrame.FRAME_HEIGHT;
import static com.test.tank.TankFrame.FRAME_WIDTH;

public class MainTank extends Tank {
    public MainTank(Frame frame) {
        super(frame);
        setX(FRAME_WIDTH-TANK_WIDTH);
        setY(FRAME_HEIGHT/2);
        setDirKey(true);
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
