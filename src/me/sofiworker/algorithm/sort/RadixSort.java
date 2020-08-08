package me.sofiworker.algorithm.sort;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/8
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] a = {53, 3, 542, 748, 14, 214};

        System.out.println(Arrays.toString(a));

        radixSort(a);

        System.out.println(Arrays.toString(a));
    }

    /**
     * 数组中不能包含负数
     * @param a 数组
     */
    private static void radixSort(int[] a) {
        int[][] bucket = new int[10][a.length];
        // 每个桶中元素的个数
        int[] counts = new int[10];

        int max = a[0];
        for (int item : a) {
            if (item > max) {
                max = item;
            }
        }

        int length = String.valueOf(max).length();
        for (int i = 0; i < length; i++) {
            for (int value : a) {
                int now = (int) (value / Math.pow(10, i)) % 10;
                bucket[now][counts[now]] = value;
                counts[now]++;
            }
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                for (int l = 0; l < counts[k]; l++) {
                    a[index] = bucket[k][l];
                    bucket[k][l] = 0;
                    index++;
                }
                counts[k] = 0;
            }
            System.out.println("---"+Arrays.toString(a));
        }
    }
}
