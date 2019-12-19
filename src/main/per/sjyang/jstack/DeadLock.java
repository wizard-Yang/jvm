package main.per.sjyang.jstack;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author saijun.yang
 * @date Created in 2019/12/10 15:02
 * @description 演示死锁下，堆栈跟踪下的信息
 */
public class DeadLock {
    public static Lock lock1 = new ReentrantLock();
    public static  Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        deathLock();
    }

    public static void deathLock() {
        Thread t1 = new Thread() {
            @Override
            public void run() {

                try {
                    lock1.lock();
                    TimeUnit.SECONDS.sleep(1);
                    lock2.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    lock2.lock();
                    TimeUnit.SECONDS.sleep(1);
                    lock1.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.setName("mythread1");
        t2.setName("mythread2");
        t1.start();
        t2.start();
    }
}
