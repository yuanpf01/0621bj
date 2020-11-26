package com.atguigu;

import java.util.jar.JarEntry;

/**
 * @author yuanpf
 * @create 2020-11-26 19:23
 *
 * 选择排序
 */
public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] a = new int[]{4,54,34,64,24,74,44};
//        selectSortMethod(a);
        for (int i = 0; i < a.length-1; i++) {
            //设定基准位置，i i++
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                //得到基准位置，最小值的下标
                if (a[j] < a[index]){//如果基准位置的值大于数组中准位置下一个位置的值，
                    index=j;//基准位置改变,  得到最小值的下标，第二小值的下标，第三小值的下标
                }
            }
            int max = a[i];//
            a[i] = a[index];//基准位置的值和最小值进行交换   a[index]小值    a[i] 大值 
            a[index] = max;       //即 基准位置的值和基准位置后面的任意一个值相比永远是最小的
        }
        for (int i : a) {
            System.out.println(i);
        }
    }
//    private static void selectSortMethod(int[] a){
//        for (int i = 0; i < a.length-1; i++) {
//            //设定基准位置，i i++
//            int index = i;
//            for (int j = i + 1; j < a.length; j++) {
//                //得到基准位置，最小值的下标
//                if (a[j] < a[index]){//如果基准位置的值大于数组中准位置下一个位置的值，
//                    index=j;//基准位置改变,  得到最小值的下标，第二小值的下标，第三小值的下标
//                }
//            }
//            int max = a[i];//
//            a[i] = a[index];//基准位置的值和最小值进行交换   a[index]小值    a[i] 大值 
//            a[index] = max;       //即 基准位置的值和基准位置后面的任意一个值相比永远是最小的
//        }
//        
//    }
}
