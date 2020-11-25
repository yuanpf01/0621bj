package com.atguigu;

/**
 * @author yuanpf
 * @create 2020-11-25 22:15
 */
public class SingLeton {
//    private static  SingLeton instance = null;  //由于指令重排，仍然存在线程不安全的问题
    private static volatile SingLeton instance = null;
    private SingLeton(){//构造器私有化
        System.out.println("私有化的无参构造器");
    }
//    public static synchronized SingLeton getInstance(){
    public static SingLeton getInstance(){//DCL:双端检索机制  double check lock
        if (instance == null){
            synchronized (SingLeton.class){
                if (instance==null){
                    instance=new SingLeton();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingLeton instance = SingLeton.getInstance();
//                System.out.println("instance = " + instance);
                },String.valueOf(i).toString()).start();
        }
    }



}
