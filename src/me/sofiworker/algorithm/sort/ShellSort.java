package me.sofiworker.algorithm.sort;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sofiworker
 * @date 2020/8/7
 */
public class ShellSort {

    public static void main(String[] args) {
//        int[] a = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        int[] a = new int[80000];
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i < 80000; i++) {
            a[i] = current.nextInt(10000000);
        }
//        swapSort(a);
        System.out.println(LocalDateTime.now());
        insertSort(a);
        System.out.println(LocalDateTime.now());
    }

    // 交换的希尔排序
    private static void swapSort(int[] a) {
        // gap：步长
        for (int gap = a.length /  2; gap > 0 ; gap = gap / 2) {
            for (int i = gap; i < a.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (a[j] > a[j+gap]) {
                        int temp = a[j];
                        a[j] = a[j+gap];
                        a[j+gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    // 插入版希尔排序
    private static void insertSort(int[] a) {
        // gap：步长
        for (int gap = a.length /  2; gap > 0 ; gap = gap / 2) {
            for (int i = gap; i < a.length; i++) {
                int j;
                int insertVal = a[i];
                for (j = i - gap; j >= 0 && insertVal < a[j]; j -= gap) {
                    a[j+gap] = a[j];
                }
                a[j+gap] = insertVal;
            }
        }
//        System.out.println(Arrays.toString(a));
    }
}
