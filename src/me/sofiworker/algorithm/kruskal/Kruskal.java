package me.sofiworker.algorithm.kruskal;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/15
 */
public class Kruskal {

    private int edgeNum;
    private char[] vertex;
    private int[][] matrix;
    // 表示两个顶点不连通
    private static final int INF = Integer.MAX_VALUE;


    public Kruskal(char[] vertex, int[][] matrix) {
        int len = vertex.length;
        this.vertex = new char[len];
        System.arraycopy(vertex, 0, this.vertex, 0, vertex.length);
        this.matrix = new int[len][len];
        System.arraycopy(matrix, 0, this.matrix, 0, matrix.length);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                System.out.printf("%12d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    /**
     *
     * @param ch 顶点的值
     * @return 顶点的下标
     */
    public int getPosition(char ch) {
        for (int i = 0; i < vertex.length; i++) {
            if (ch == vertex[i]) {
                return i;
            }
        }
        return -1;
    }

    public EData[] getEdges() {
        int index = 0;
        EData[] result = new EData[edgeNum];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i + 1; j < vertex.length; j++) {
                if (matrix[i][j] != INF) {
                    result[index++] = new EData(vertex[i], vertex[j], matrix[i][j]);
                }
            }
        }
        return result;
    }

    /**
     * 获取下标为 i 顶点的终点，用于判断是否构成环路
     * @param ends 顶点的终点是哪个，是在遍历的过程中逐渐形成的
     * @param i 传入顶点的下标
     * @return 下标为 i 的顶点的终点下标
     */
    public int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public EData[] kruskal() {
        int index = 0;
        // 用于保存 “最小生成树” 中每个顶点在最小生成树中的终点
        int[] ends = new int[edgeNum];
        // 创建结果数组
        EData[] result = new EData[edgeNum];

        // 获取图中所有边的集合
        EData[] edges = getEdges();
        sortEdges(edges);
        for (int i = 0; i < edges.length; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            int start = getEnd(ends, p1);
            int end = getEnd(ends, p2);

            if (start != end) {
                ends[start] = end;
                result[index++] = edges[i];
            }
        }
        return result;
    }

    static class EData {
        // 边的起点
        char start;
        // 边的终点
        char end;
        // 权值
        int weight;

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "EData{" +
                    "start=" + start +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0},
        };
        Kruskal kruskal = new Kruskal(vertex, matrix);
        System.out.println(Arrays.toString(kruskal.kruskal()));

    }
}
