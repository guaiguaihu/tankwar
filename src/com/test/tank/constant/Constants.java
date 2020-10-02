package com.test.tank.constant;

import com.test.tank.util.PropertyManager;

public interface Constants {
    int TANK_SIZE = PropertyManager.getInteger("tankSize");
    int FRAME_WIDTH = 800;
    int FRAME_HEIGHT = 600;
}
