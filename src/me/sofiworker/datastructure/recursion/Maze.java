package me.sofiworker.datastructure.recursion;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/6
 *
 * 迷宫问题
 */
public class Maze {

    public static void main(String[] args) {
        int[][] map = new int[8][7];
        // 1 表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
        setWay(map, 1, 1);
        System.out.println("-----------------------");
        // 走过的路
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * map[6][5] 表示终点，从（1，1）出发
     * 1 表示墙，2 表示通路，3 表示已经走过但不通
     * 走动的策略为：下 -> 右 -> 上 -> 左  策略不同路径也不同
     * @param map 地图
     * @param i 从那个位置开始找
     * @return 找到通路返回 true
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }else {
            if (map[i][j] == 0) {
                //将该点置为可走的
                map[i][j] = 2;
                // 向下
                if (setWay(map, i+1, j)) {
                    return true;
                    //向右
                }else if (setWay(map, i, j+1)) {
                    return true;
                    //向上
                }else if (setWay(map, i-1, j)) {
                    return true;
                    //向左
                } else if (setWay(map, i, j-1)) {
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                //map[i][j] != 0，说明该点走过了
                return false;
            }
        }
    }
}
