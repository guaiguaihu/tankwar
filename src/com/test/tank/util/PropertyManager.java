package com.test.tank.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置管理器
 *
 * @author: liujinliang
 * @create: 2020-10-02 14:35
 **/
public class PropertyManager {
    private  static Properties property = null;

    private static class PropertyHolder{
        static final Properties properties = new Properties();

        static {
            try {
                properties.load(PropertyManager.class.getResourceAsStream("/config/config"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Properties getInstance(){
        if(property == null){
            property = PropertyHolder.properties;
        }
        return property;
    }


    public static String getString(String key){
        Object value = getInstance().get(key);
        if(value == null){
            return null;
        }
        return String.valueOf(value);
    }

    public static Integer getInteger(String key){
        Object value = getInstance().get(key);
        if(value == null){
            return null;
        }
        return Integer.parseInt(String.valueOf(value));
    }
}
