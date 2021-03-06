package me.sofiworker.algorithm.floyd;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/15
 */
public class Floyd {

    static class Graph {
        private char[] vertex;
        private int[][] dis;
        private int[][] pre;

        public Graph(int len, int[][] matrix, char[] vertex) {
            this.vertex = vertex;
            this.dis = matrix;
            this.pre = new int[len][len];
            for (int i = 0; i < pre.length; i++) {
                Arrays.fill(pre[i], i);
            }
        }

        public void show() {
            char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis.length; j++) {
                    System.out.print(vertex[pre[i][j]] + " ");
                }
                System.out.println();
                for (int j = 0; j < dis.length; j++) {
                    System.out.print("("+vertex[i]+"到"+vertex[j]+"）的最短路径："+dis[i][j] + " ");
                }
                System.out.println();
                System.out.println();
            }
        }

        public void floyd() {
            int len = 0;
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis.length; j++) {
                    for (int k = 0; k < dis.length; k++) {
                        len = dis[j][i] + dis[i][k];
                        if (len < dis[j][k]) {
                            dis[j][k] = len;
                            pre[j][k] = pre[i][k];
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};
        Graph graph = new Graph(vertex.length, matrix, vertex);
        graph.floyd();
        graph.show();
    }
}
