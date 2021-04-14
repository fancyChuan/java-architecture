package cn.fancychuan.simpledemo;

import com.fourinone.MigrantWorker;
import com.fourinone.WareHouse;

/**
 * 工人类：
 *      定义了个人的工作内容
 * 注意：这个类需要在“职介所”启动后才能启动，否则会报错
 */
public class SimpleWorker extends MigrantWorker {
    @Override
    protected WareHouse doTask(WareHouse wareHouse) {
        // 获得所需要的资源
        String word = wareHouse.getString("资源key");
        System.out.println("工人-拿到原材料：" + word + " 原材料来自Contractor");
        System.out.println("工人-原材料状态：" + wareHouse.getStatusName());
        // 对资源加工后返回
        WareHouse newWord = new WareHouse("资源key_after", "材料【" + word + "】的长度为： " + word.length());
        System.out.println("工人-加工完成，资源id为：资源key_after");
        return newWord;
    }

    public static void main(String[] args) {
        SimpleWorker mw = new SimpleWorker();
        // 工人的名字叫：simpleworker
        mw.waitWorking("simpleworker");
    }
}
