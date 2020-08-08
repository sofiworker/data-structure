package me.sofiworker.algorithm.search;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/8
 */
public class InsertSearch {

    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        System.out.println(insertSearch(a, 0, a.length - 1, 18));
    }

    private static int insertSearch(int[] a, int left, int right, int val) {
        if (left > right || val < a[0] || val > a[a.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (val - a[left]) / (a[right] - a[left]);
        if (a[mid] > val) {
            return insertSearch(a, left, mid - 1, val);
        }else if (a[mid] < val) {
            return insertSearch(a, mid + 1, right, val);
        }else {
            return mid;
        }
    }
}
