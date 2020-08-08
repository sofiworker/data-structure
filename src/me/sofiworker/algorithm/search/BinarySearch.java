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

        System.out.println(binarySearch(a, 0, a.length - 1, 1000));
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
