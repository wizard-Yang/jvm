package main.per.sjyang.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saijun.yang
 * @date Created in 2019/12/10 15:49
 * @description : 内存监控
 */
public class MonitoringTest {
    static class OOMObject{
        public byte[] placeholder = new byte[64*1024];
    }
    public static void fillHeap(int num)throws InterruptedException{
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
