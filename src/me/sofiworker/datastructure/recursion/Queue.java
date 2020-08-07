package me.sofiworker.datastructure.recursion;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/7
 */
public class Queue {

    int max = 8;
    //保存位置
    int[] pos = new int[max];
    //总共的解法
    static int count = 0;


    public static void main(String[] args) {
        new Queue().check(0);
        System.out.println("所有的解法有"+count+"种");
    }

    //由于 for 的存在中间包含回溯
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            pos[n] = i;
            if (judge(n)) {
                check(n+1);
            }
        }
    }

    /**
     * @param n 第几个皇后
     * @return 是否冲突
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (pos[i] == pos[n] || Math.abs(n - i) == Math.abs(pos[n] - pos[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        System.out.println(Arrays.toString(pos));
    }
}
