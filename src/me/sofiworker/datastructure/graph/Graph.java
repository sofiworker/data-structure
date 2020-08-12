package me.sofiworker.datastructure.graph;

import java.util.*;

/**
 * @author sofiworker
 * @date 2020/8/12
 * 无向图
 */
public class Graph {

    // 储存顶点集合
    private List<String> vertexList;
    //
    private int[][] edges;
    // 边的条数
    private int numOfEdges;

    // 用来记录节点是否访问
    private boolean[] isVisited;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisited = new boolean[n];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * @param v1 表示点的下标
     * @param v2 表示点的下标
     * @param weight 表示对应的值/权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    // 获取点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // 获取边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
        Arrays.fill(isVisited, false);
    }

    private void dfs(boolean[] isVisited, int i) {
        System.out.println(getValByIndex(i));
        isVisited[i] = true;
        int firstNeighbor = getFirstNeighbor(i);
        while (firstNeighbor != -1) {
            if (!isVisited[firstNeighbor]) {
                dfs(isVisited, firstNeighbor);
            }
            firstNeighbor = getNextNeighbor(i, firstNeighbor);
        }
    }


    private void bfs(boolean[] isVisited, int i) {
        int u;
        int w;
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(getValByIndex(i));
        isVisited[i] = true;
        linkedList.addLast(i);
        while (!linkedList.isEmpty()) {
            u = linkedList.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.println(getValByIndex(w));
                    isVisited[w] = true;
                    linkedList.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
        Arrays.fill(isVisited, false);
    }

    public static void main(String[] args) {
        int nums = 8;
//        String[] val = {"A", "B", "C", "D", "E"};
        String[] val = {"1", "2", "3", "4", "5", "6", "7", "8"};
        Graph graph = new Graph(nums);
        for (String s : val) {
            graph.insertVertex(s);
        }
        // A-B, A-C, B-C, B-D, B-E
//        graph.insertEdge(0, 1, 1);
//        graph.insertEdge(0, 2, 1);
//        graph.insertEdge(1, 2, 1);
//        graph.insertEdge(1, 3, 1);
//        graph.insertEdge(1, 4, 1);


        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
//        graph.showGraph();

        graph.dfs();
        System.out.println("-----------");
        graph.bfs();
    }
}
