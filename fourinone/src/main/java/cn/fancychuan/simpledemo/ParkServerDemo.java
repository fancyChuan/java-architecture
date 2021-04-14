package cn.fancychuan.simpledemo;

import com.fourinone.BeanContext;

public class ParkServerDemo {
    public static void main(String[] args) {
        BeanContext.setConfigFile("config.xml");
        BeanContext.startPark();
    }
}
