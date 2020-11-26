package com.atguigu;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuanpf
 * @create 2020-11-26 23:08
 */
public class CreatedThread {
    public static void main(String[] args) {
        //继承thread类的方式创建线程：
        new Thread(()->{
            System.out.println("但使龙城飞将在，不教胡马度阴山！");
        },"CreateThreadOne").start();
        //通过callable接口创建线程
        new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("呼儿将出换美酒，与尔同销万古愁！");
                return null;
            }
        });
        //通过线程池创建线程
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,//核心线程数
                5,//最大线程数
                3L,//线程空闲时间
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),//队列
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()//拒绝策略
        );
        try {
            for (int i = 0; i < 1; i++) {//从线程池创建获取线程
                threadPoolExecutor.execute(() -> {
                    System.out.println("人生若只如初见，何事秋风悲画扇！");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPoolExecutor.shutdown();
        }
    }
}
//实现Runable接口的方式创建线程！
class CreateThreadTwo  implements Runnable{

    @Override
    public void run() {
        System.out.println("左牵你，右擎他，锦帽貂裘，一骑红尘妃子笑！");
    }
}
