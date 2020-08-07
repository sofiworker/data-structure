package me.sofiworker.algorithm.sort;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/7
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{101, 34, 119, 1};

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != -1) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
