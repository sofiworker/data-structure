package me.sofiworker.algorithm.prim;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/15
 */
public class Prim {

    static class Graph {

        int vertex;
        char[] data;
        int[][] weight;

        public Graph(int vertex) {
            this.vertex = vertex;
            data = new char[vertex];
            weight = new int[vertex][vertex];
        }
    }

    // 创建最小生成树
    static class MinTree {

        /**
         * 创建图
         * @param graph 图对象
         * @param vertex 图对应的顶点
         * @param data 图中顶点的值
         * @param weight 图的零阶矩阵
         */
        public void createGraph(Graph graph, int vertex, char[] data, int[][] weight) {
            int i, j;
            for (i = 0; i < vertex; i++) {
                graph.data[i] = data[i];
                for (j = 0; j < vertex; j++) {
                    graph.weight[i][j] = weight[i][j];
                }
            }
        }

        public void showGraph(Graph graph) {
            for (int[] ints : graph.weight) {
                System.out.println(Arrays.toString(ints));
            }
        }

        /**
         *
         * @param graph 图
         * @param v 从第几个顶点开始生成
         */
        public void prim(Graph graph, int v) {
            // 节点是否访问
            int[] visited = new int[graph.vertex];
            visited[v] = 1;
            // 记录两个顶点的下标
            int h1 = -1, h2 = -1;
            int minWeight = 10000;
            for (int k = 1; k < graph.vertex; k++) {

                for (int i = 0; i < graph.vertex; i++) {
                    for (int j = 0; j < graph.vertex; j++) {
                        if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                            minWeight = graph.weight[i][j];
                            h1 = i;
                            h2 = j;
                        }
                    }
                }
                System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+"> 权值："+minWeight);
                visited[h2] = 1;
                minWeight = 10000;
            }
        }

    }

    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertex = data.length;
        // 10000 表示两点之间不连通
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},
        };
        Graph graph = new Graph(vertex);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, vertex, data, weight);
//        minTree.showGraph(graph);
        minTree.prim(graph, 0);
    }
}
