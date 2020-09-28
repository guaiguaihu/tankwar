package com.test.tank;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static com.test.tank.TankFrame.FRAME_HEIGHT;

public class BlueTank extends Tank {
    public BlueTank(Frame frame, String image) {
        super(frame);
        setImage(image);
        setX(0);
        setY(FRAME_HEIGHT/2);
        setDirKey(false);
    }
}
