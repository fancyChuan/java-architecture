package cn.fancychuan.simpledemo;

import com.fourinone.BeanContext;

/**
 * 职介所类，需要比“工人”实例先启动
 */
public class ParkServerDemo {
    public static void main(String[] args) {
        BeanContext.setConfigFile("config.xml");
        BeanContext.startPark();
    }
}
