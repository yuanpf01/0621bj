package com.atguigu;

import java.util.concurrent.TimeUnit;

/**
 * @author yuanpf
 * @create 2020-11-25 18:47
 * 手写一个死锁 示例
 */
    public class DeadLock {
        public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        new Thread(()->{
        synchronized (o1){
            System.out.println("我的大中国哇！");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println("天王盖地虎！！");
            }
        }
            },"").start();
        new Thread(()->{
        synchronized (o2){
            System.out.println("小鸡炖蘑菇");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("死锁模式已开启！");
            }
        }
            },"").start();
    }
}
