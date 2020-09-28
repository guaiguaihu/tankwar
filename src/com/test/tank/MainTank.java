package com.test.tank;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static com.test.tank.TankFrame.FRAME_HEIGHT;
import static com.test.tank.TankFrame.FRAME_WIDTH;

public class MainTank extends Tank {
    public MainTank(Frame frame, String image) {
        super(frame);
        setImage(image);
        setX(FRAME_WIDTH-TANK_WIDTH);
        setY(FRAME_HEIGHT/2);
        setDirKey(true);
    }
}
