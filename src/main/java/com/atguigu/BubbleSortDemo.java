package com.atguigu;

/**
 * @author yuanpf
 * @create 2020-11-26 18:53
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] a = new int[]{34,54,14,44,74,84,64,24};
        bubbleSortMethod(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
    private static void bubbleSortMethod(int[] num){
        for (int i = 0; i < num.length-1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] < num[j+1]) {
                    int min = num[j];
                    num[j] = num[j+1];
                    num[j+1] = min;
                }
            }
        }

    }
}
