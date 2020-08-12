package me.sofiworker.datastructure.tree;

/**
 * @author sofiworker
 * @date 2020/8/10
 * 顺序储存二叉树
 */
public class ArrayBinaryTree {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};

        Tree tree = new Tree(a);
        tree.preOrder();
    }

    static class Tree {
        private int[] data;

        public Tree(int[] data) {
            this.data = data;
        }

        public void preOrder() {
            this.preOrder(0);
        }

        private void preOrder(int index) {
            if (data == null || data.length == 0) {
                throw new RuntimeException("数组为空");
            }
            System.out.println(data[index]);
            if ((2 * index + 1) < data.length) {
                preOrder(2 * index + 1);
            }
            if ((2 * index + 2) < data.length) {
                preOrder(2 * index + 2);
            }
        }
    }
}
