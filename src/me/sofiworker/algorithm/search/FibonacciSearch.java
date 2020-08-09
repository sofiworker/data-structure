package me.sofiworker.algorithm.search;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/9
 */
public class FibonacciSearch {

    private static int maxSize = 20;


    public static void main(String[] args) {
        int[] a = {1, 8, 10, 89, 1000, 1234};

        System.out.println(fibSearch(a, 12234));
    }

    // 得到一个斐波那契数组
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int height = a.length - 1;
        // 表示斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        int[] f = fib();
        while (height > f[k] - 1) {
            k++;
        }
        // 因为f[k] 可能大于 a 的长度，构造一个新的数组并指向 temp
        int[] temp = Arrays.copyOf(a, f[k]);
        for (int i = height + 1; i < temp.length; i++) {
            temp[i] = a[height];
        }

        while (low <= height) {
            mid = low + f[k-1] - 1;
            if (key < temp[mid]) {
                height = mid - 1;
                k--;
            }else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
                // 找到了
            }else {
                return Math.min(mid, height);
            }
        }
        return -1;
    }
}
