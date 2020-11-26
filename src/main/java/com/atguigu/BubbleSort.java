package com.atguigu;

/**
 * @author yuanpf
 * @create 2020-11-26 15:45
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] number = new int[]{12,42,62,72,32,52,22,82};
        int min = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length-i-1; j++) {
                if (number[j] < number[j+1]){
                    min=number[j];
                    number[j]=number[j+1];
                    number[j+1]=min;
                }
            }
        }
        System.out.println("最终得到的数组为：-------"+number);
        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }
    }
}
