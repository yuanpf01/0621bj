package com.atguigu;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yuanpf
 * @create 2020-11-25 23:03
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
            // atomicInteger.compareAndSet(5,2020)当jmm内存模型中的主内存中的变量为5的时候，
            // 将变量从主内存中拷贝出来修改为2020并重新写回主内存
        System.out.println(Thread.currentThread().getName() + "\t::"
                            + atomicInteger.compareAndSet(5,2020)
                            + "\tresult==" + atomicInteger.get());
        System.out.println(Thread.currentThread().getName() + "\t::"
                            + atomicInteger.compareAndSet(5,10086)
                            + "\tresult==" + atomicInteger.get());
    }
}
