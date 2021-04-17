package cn.fancychuan.fulldemo;

import com.fourinone.MigrantWorker;
import com.fourinone.WareHouse;

public class WorkerDemo extends MigrantWorker {
    private String workerName;

    public WorkerDemo(String workerName) {
        this.workerName = workerName;
    }

    @Override
    protected WareHouse doTask(WareHouse inHouse) {
        String v = inHouse.getString("id");
        System.out.println(workerName + " inhouse:" + v);
        return new WareHouse("id", v + "-" + workerName + "-");
    }

    public static void main(String[] args) {
        WorkerDemo wd = new WorkerDemo(args[0]);
        wd.waitWorking("localhost", Integer.parseInt(args[1]), "workdemo");
    }
}

