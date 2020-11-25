package com.atguigu;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yuanpf
 * @create 2020-11-25 23:03
 * 为什么使用atomicInteger.incrementAndGet()方法可以保证原子性？
 * 		因为incrementAndGet()方法调用了unsafe类中的getAndSetInt(object a ,long b,long c)方法，该方法被native修饰，存储在本地方法栈里面，调用的是jvm底层的东西，CAS全称Compare-And-Swap ,是一条并发原语，原语的执行必须是连续的，不允许中途被打断，因此不存在所谓的数据不一致的问题。
 *       例：JMM内存模型中，主内存区存在一个共享变量 int a = 10 ;
 * 				线程A、B分别从主内存区读取到了变量a并拷贝到了各自的栈内存中，
 * 				假如线程A先将变量a修改为100并写入主内存中，此时主内存中的变量a = 100;
 * 				此时线程B如果也要对自己的栈内存中的变量进行修改，getAndSetInt(object a,long b ,long c)方法中会首先获取主内存中的变量值和
 * 		和自己栈内存中的变量的值进行比较，如果相等，则开始修改，如果不相等，则修改失败，什么都不做，知道二者相同的时候才开始修改
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
        atomicInteger.incrementAndGet();
    }
}
