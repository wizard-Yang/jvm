package main.per.sjyang.jconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author saijun.yang
 * @date Created in 2019/12/10 16:13
 * @description 线程监控测试
 */
public class ThreadTest {
    /**
     * 线程死锁演示
     */
    public static void createBusyThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true);
            }
        },"testBusyThread");
        thread.start();
    }
    /**
     * 线程等待演示
     */
    public static void createLockThread(final Object lock){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
       // createBusyThread();
        //bufferedReader.readLine();
        Object object = new Object();
        createLockThread(object);
    }
}
