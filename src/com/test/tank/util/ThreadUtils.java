package com.test.tank.util;

/**
 * 封装线程工具类
 *
 * @author: liujinliang
 * @create: 2020-09-29 06:50
 **/
public class ThreadUtils {
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
