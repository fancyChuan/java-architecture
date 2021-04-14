package cn.fancychuan.simpledemo;

import com.fourinone.Contractor;
import com.fourinone.WareHouse;
import com.fourinone.WorkerLocal;

public class SimpleCtor extends Contractor {
    @Override
    public WareHouse giveTask(WareHouse wareHouse) {
        WorkerLocal[] wks = getWaitingWorkers("simpleworker");
        System.out.println("wks.length: " + wks.length);

        WareHouse wh = new WareHouse("word", "hello");
        WareHouse result = wks[0].doTask(wh);
        while (true) {
            if (result.getStatus() == WareHouse.READY) {
                System.out.println("result: " + result);
                break;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleCtor simpleCtor = new SimpleCtor();
        simpleCtor.giveTask(null);
    }
}
