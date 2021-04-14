package cn.fancychuan.simpledemo;

import com.fourinone.MigrantWorker;
import com.fourinone.WareHouse;

public class SimpleWorker extends MigrantWorker {
    @Override
    protected WareHouse doTask(WareHouse wareHouse) {
        String word = wareHouse.getString("word");
        System.out.println(word + " from Contractor");
        return new WareHouse("word", word + " world!");
    }

    public static void main(String[] args) {
        SimpleWorker mw = new SimpleWorker();
        mw.waitWorking("simpleworker");
    }
}
