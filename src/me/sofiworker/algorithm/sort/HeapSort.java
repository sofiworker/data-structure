package me.sofiworker.algorithm.sort;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/10
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {4, 6, 34, 8, -1, 5, 9};

        heapSort(a);
    }

    public static void heapSort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            adjustHeap(a, i, a.length);
        }
        int temp = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            adjustHeap(a, 0, i);
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 将数组转为大顶堆树，从小到大排列
     * @param a 数组
     * @param i 非叶子节点在数组中的索引
     * @param len 表示对多少个元素继续调整，会逐渐减少
     */
    public static void adjustHeap(int[] a, int i, int len) {
        int temp = a[i];
        for (int k = i * 2 + 1; k < len; k = i * 2 + 1) {
            if (k + 1 < len && a[k] < a[k+1]) {
                k++;
            }
            if (a[k] > temp) {
                a[i] = a[k];
                i = k;
            }else {
                break;
            }
        }
        a[i] = temp;
    }
}
