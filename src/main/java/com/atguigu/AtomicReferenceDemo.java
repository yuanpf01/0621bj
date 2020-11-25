package com.atguigu;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yuanpf
 * @create 2020-11-26 0:42
 * 原子引用
 *
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User tom = new User("tom", 25);
        User lisi = new User("lisi",38);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(tom);
        System.out.println(atomicReference.compareAndSet(tom,lisi) + "\tresult==" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(tom,lisi) + "\tresult==" + atomicReference.get().toString());
    }
}
class User{
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
