package me.sofiworker.algorithm.dijkstra;

import java.util.Arrays;

/**
 * @author sofiworker
 * @date 2020/8/15
 */
public class Dijkstra {

    static class Graph {
        private char[] vertex;
        private int[][] matrix;
        private VisitedVertex visitedVertex;

        public Graph(char[] vertex, int[][] matrix) {
            this.vertex = vertex;
            this.matrix = matrix;
        }

        public void showGraph() {
            for (int[] ints : matrix) {
                System.out.println(Arrays.toString(ints));
            }
        }

        public void dsj(int index) {
            visitedVertex = new VisitedVertex(vertex.length, index);
            // 更新 index 顶点到周围顶点的距离和前驱节点
            update(index);
            for (int j = 0; j < vertex.length; j++) {
                index = visitedVertex.updateArray();
                update(index);
            }
        }

        // 更新 index 下标顶点到周围顶点的距离和周围顶点的前驱节点
        private void update(int index) {
            int len = 0;
            for (int j = 0; j < matrix[index].length; j++) {
                len = visitedVertex.getDis(index) + matrix[index][j];
                if (!visitedVertex.in(j) && len < visitedVertex.getDis(j)) {
                    visitedVertex.updatePre(j, index);
                    visitedVertex.updateDis(j, len);
                }
            }
        }

        public void showDsj() {
            visitedVertex.show();
        }
    }

    static class VisitedVertex {
        private final int[] alreadyArray;
        private final int[] preVisited;
        public int[] dis;

        public VisitedVertex(int len, int index) {
            this.alreadyArray = new int[len];
            this.preVisited = new int[len];
            this.dis = new int[len];
            Arrays.fill(dis, 65535);
            this.alreadyArray[index] = 1;
            this.dis[index] = 0;
        }

        /**
         * 判断 index 节点是否访问
         */
        public boolean in(int index) {
            return alreadyArray[index] == 1;
        }

        // 更新出发顶点到 index 顶点的距离
        public void updateDis(int index, int len) {
            dis[index] = len;
        }

        // 更新顶点的前驱节点为 index 节点
        public void updatePre(int pre, int index) {
            preVisited[pre] = index;
        }

        public int getDis(int index) {
            return dis[index];
        }

        public int updateArray() {
            int min = 65535, index = 0;
            for (int i = 0; i < alreadyArray.length; i++) {
                if (alreadyArray[i] == 0 && dis[i] < min) {
                    min = dis[i];
                    index = i;
                }
            }
            alreadyArray[index] = 1;
            return index;
        }

        public void show() {
            System.out.println("================");
            System.out.println(Arrays.toString(alreadyArray));
            System.out.println("================");
            System.out.println(Arrays.toString(preVisited));
            System.out.println("================");
            System.out.println(Arrays.toString(dis));
        }
    }

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

        Graph graph = new Graph(vertex, matrix);
        graph.dsj(6);
        graph.showDsj();
    }
}
