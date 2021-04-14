package cn.fancychuan.simpledemo;

import com.fourinone.Contractor;
import com.fourinone.WareHouse;
import com.fourinone.WorkerLocal;

/**
 * 包工头类：有需要是，获取工人，并将原材料放入仓库
 */
public class SimpleCtor extends Contractor {
    @Override
    public WareHouse giveTask(WareHouse wareHouse) {
        // 指定要类型为simpleworker的工人
        WorkerLocal[] wks = getWaitingWorkers("simpleworker");
        System.out.println("包工头-获得的工人数（wks.length）: " + wks.length);

        // 这里是定义资源
        WareHouse wh = new WareHouse("资源key", "资源value");
        // 从工人中找一个人出来完成任务
        WareHouse result = wks[0].doTask(wh);
        while (true) {
            // 判断任务的状态
            if (result.getStatus() == WareHouse.READY) {
                System.out.println("包工头-任务状态为：" + result.getStatusName());
                System.out.println("工人处理结果result: " + result);
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
