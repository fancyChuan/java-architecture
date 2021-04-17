package cn.fancychuan.fulldemo;

import com.fourinone.Contractor;
import com.fourinone.WareHouse;
import com.fourinone.WorkerLocal;

public class CtorDemo extends Contractor {
    private String ctorName;

    public CtorDemo(String ctorName) {
        this.ctorName = ctorName;
    }

    @Override
    public WareHouse giveTask(WareHouse inHouse) {
        WorkerLocal[] wks = getWaitingWorkers("workdemo");
        System.out.println("共有工人：" + wks.length);
        String outStr = inHouse.getString("id");
        WareHouse[] hmarr = new WareHouse[wks.length];
        int data = 0;
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < wks.length; i++) {
                if (hmarr[i] == null) {
                    WareHouse wh = new WareHouse();
                    wh.put("id", ctorName + (data++));
                    hmarr[i] = wks[i].doTask(wh);
                }
                else if (hmarr[i].getStatus() != WareHouse.NOTREADY) {
                    System.out.println(hmarr[i]);
                    outStr += hmarr[i];
                    hmarr[i] = null;
                    j++;
                }
            }
        }
        inHouse.setString("id", outStr);
        return inHouse;
    }

    public static void main(String[] args) {
        CtorDemo a = new CtorDemo("OneCtor");
        a.toNext(new CtorDemo("TwoCtor")).toNext(new CtorDemo("ThreeCtor"));
        WareHouse house = new WareHouse("id", "begin ");
        System.out.println(a.giveTask(house, true));
    }
}
