package me.sofiworker.algorithm.dp;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/14
 *
 * 动态规划 - 背包问题
 */
public class Knapsack {

    public static void main(String[] args) {
        // 物品的重量
        int[] weight = {1, 4, 3};
        // 物品价值
        int[] value = {1500, 3000, 2000};
        // 背包最大容量
        int maxWeight = 4;
        // 物品个数
        int nums = value.length;
        // 表格背包表格
        int[][] form = new int[nums + 1][maxWeight + 1];

        for (int i = 0; i < form.length; i++) {
            form[i][0] = 0;
        }
        Arrays.fill(form[0], 0);

        int[][] path = new int[nums + 1][maxWeight + 1];

        for (int i = 1; i < form.length; i++) {
            for (int j = 1; j < form[i].length; j++) {
                if (weight[i - 1] > j) {
                    form[i][j] = form[i - 1][j];
                }else {
//                    form[i][j] = Math.max(form[i - 1][j], value[i - 1] + form[i - 1][j - weight[i - 1]]);
                    if (form[i - 1][j] < value[i - 1] + form[i - 1][j - weight[i - 1]]) {
                        path[i][j] = 1;
                        form[i][j] = value[i - 1] + form[i - 1][j - weight[i - 1]];
                    }else {
                        form[i][j] = form[i - 1][j];
                    }
                }
            }
        }

        for (int[] ints : form) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println("---------------");
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包\n", i);
                j -= weight[i - 1];
            }
            i--;
        }
    }


}
