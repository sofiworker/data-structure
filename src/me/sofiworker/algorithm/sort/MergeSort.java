package me.sofiworker.algorithm.sort;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/8
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {8, 4, 5, 7, 79, -41, 3, 6, 2, -1, 43};
        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length-1, temp);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid, temp);
            mergeSort(a, mid + 1, right, temp);
            merge(a, left, mid, right, temp);
        }
    }

    private static void merge(int[] a, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        // temp 数组的当前指针
        int t = 0;

        while (l <= mid && r <= right) {
            if (a[l] <= a[r]) {
                temp[t] = a[l];
                t++;
                l++;
            }else {
                temp[t] = a[r];
                t++;
                r++;
            }
        }
        while (l <= mid) {
            temp[t] = a[l];
            t++;
            l++;
        }
        while (r <= right) {
            temp[t] = a[r];
            t++;
            r++;
        }

        // 并不是每次将所有的元素从临时数组拷贝到原数组
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            a[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
