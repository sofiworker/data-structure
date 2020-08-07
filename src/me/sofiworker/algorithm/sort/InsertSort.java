package me.sofiworker.algorithm.sort;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/7
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = new int[]{101, 34, -1, 200, 119, 1};

        for (int i = 1; i < a.length; i++) {
            int insertVal = a[i];
            for (int j = i; j >= 0; j--) {
                if (insertVal < a[j]) {
                    a[j+1] = a[j];
                    a[j] = insertVal;
                }
            }
            System.out.println(Arrays.toString(a));
        }
    }
}
