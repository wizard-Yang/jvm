package main.per.sjyang.jps;

/**
 * @author saijun.yang
 * @date Created in 2019/12/10 13:36
 * @description 一直启动一个程序
 */
public class Jps {
    public static void main(String[] args) {
        System.out.println("开始执行");
        OtherClass otherClass = new OtherClass();
        try {
            Thread.sleep(90000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        otherClass.function();
        System.out.println("结束执行");
    }
}
