package me.sofiworker.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sofiworker
 * @date 2020/8/8
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 8, 10, 89, 1000, 1000, 1234, 12345};

        System.out.println(binarySearch(a, 1000));
    }

    // 非递归实现
    private static int binarySearch(int[] a, int val) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == val) {
                return mid;
            }else if (a[mid] > val) {
                right = mid - 1;
            }else if (a[mid] < val) {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] a, int l, int r, int val) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (val < a[mid]) {
            return binarySearch(a, l, mid - 1, val);
        }else if (val > a[mid]) {
            return binarySearch(a, mid + 1, r, val);
        }else {
            return mid;
        }
    }

    /**
     * 未完成
     * 存在多个同一数值的下标
     * @param a
     * @param l
     * @param r
     * @param val
     * @return
     */
    private static List<Integer> binarySearch2(int[] a, int l, int r, int val) {
        if (l > r) {
            return new ArrayList<>();
        }
        int mid = (l + r) / 2;
        if (val < a[mid]) {
            return binarySearch2(a, l, mid - 1, val);
        }else if (val > a[mid]) {
            return binarySearch2(a, mid + 1, r, val);
        }else {
            List<Integer> list = new ArrayList<>();
            return list;
        }
    }
}
