package main.per.sjyang.jconsole;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author saijun.yang
 * @date Created in 2019/12/10 16:29
 * @description 死锁演示
 */
public class ThreadLockDead implements Runnable{
    int a,b;
    public ThreadLockDead(int a,int b){
        this.a = a;
        this.b= b;
    }


    @Override
    public void run() {
        synchronized (Integer.valueOf(a)){
            synchronized (Integer.valueOf(b)){
                System.out.println(a+b);
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 1000; i++) {
            new Thread(new ThreadLockDead(1,2)).start();
            new Thread(new ThreadLockDead(2,1)).start();
        }
    }
}
