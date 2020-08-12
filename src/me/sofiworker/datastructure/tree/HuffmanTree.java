package me.sofiworker.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sofiworker
 * @date 2020/8/11
 * 哈夫曼树
 */
public class HuffmanTree {

    static class Node implements Comparable<Node> {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) {
        int[] a = {13, 7, 8, 3, 29, 6, 1};
        createTree(a);
    }

    public static void createTree(int[] a) {
        List<Node> nodes = new ArrayList<>();
        for (int i : a) {
            nodes.add(new Node(i));
        }
        Collections.sort(nodes);

        while (nodes.size() > 1) {
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.val + right.val);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
            Collections.sort(nodes);
        }

        preOrder(nodes.get(0));
    }

    public static void preOrder(Node node) {
        System.out.println(node);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }
}
