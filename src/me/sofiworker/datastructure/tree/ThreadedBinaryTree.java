package me.sofiworker.datastructure.tree;

/**
 * @author sofiworker
 * @date 2020/8/10
 * 线索化二叉树
 */
public class ThreadedBinaryTree {

    static class Node {
        int no;
        String name;
        Node left;
        Node right;
        // 0：表示指向的左子树，1：表示前驱节点
        int leftType;
        // 0：表示指向的右子树，1：表示后继节点
        int rightType;

        public Node(int no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

        // 前序遍历
        public void preOrder() {
            System.out.println(this);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        // 中序遍历
        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        // 后续遍历
        public void postOrder() {
            if (this.left != null) {
                this.left.postOrder();
            }
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.println(this);
        }

        public Node preFind(int no) {
            if (this.no == no) {
                return this;
            }
            Node res = null;
            if (this.left != null) {
                res = this.left.preFind(no);
            }
            if (this.right != null) {
                res = this.right.preFind(no);
            }
            return res;
        }

        public Node infixFind(int no) {
            Node res = null;
            if (this.left != null) {
                res = this.left.infixFind(no);
            }
            if (this.no == no) {
                return this;
            }
            if (this.right != null) {
                res = this.right.infixFind(no);
            }
            return res;
        }

        public Node postFind(int no) {
            Node res = null;
            if (this.left != null) {
                res = this.left.postFind(no);
            }
            if (this.right != null) {
                res =  this.right.postFind(no);
            }
            if (this.no == no) {
                return this;
            }
            return res;
        }

        /**
         * 如果节点非叶子节点会将其子树同时删除
         * @param no 编号
         */
        public void deleteNode(int no) {
            if (this.left != null && this.left.no == no) {
                this.left = null;
                return;
            }
            if (this.right != null && this.right.no == no) {
                this.right = null;
                return;
            }
            if (this.left != null) {
                this.left.deleteNode(no);
            }
            if (this.right != null) {
                this.right.deleteNode(no);
            }
        }
    }

    static class Tree {
        private Node root;
        // 递归时，该变量保留前一个节点
        private Node preNode;

        public void setRoot(Node root) {
            this.root = root;
        }

        public void preOrder() {
            if (this.root != null) {
                this.root.preOrder();
            }else {
                throw new RuntimeException("根节点为空");
            }
        }

        public void postOrder() {
            if (this.root != null) {
                this.root.postOrder();
            }else {
                throw new RuntimeException("根节点为空");
            }
        }

        public void infixOrder() {
            if (this.root != null) {
                this.root.infixOrder();
            }else {
                throw new RuntimeException("根节点为空");
            }
        }

        public Node preFind(int no) {
            if (this.root != null) {
                return this.root.preFind(no);
            }else {
                throw new RuntimeException("根节点为空");
            }
        }

        public Node infixFind(int no) {
            if (this.root != null) {
                return this.root.infixFind(no);
            }else {
                throw new RuntimeException("根节点为空");
            }
        }

        public Node postFind(int no) {
            if (this.root != null) {
                return this.root.postFind(no);
            }else {
                throw new RuntimeException("根节点为空");
            }
        }

        /**
         * 如果节点非叶子节点会将其子树同时删除
         * @param no 编号
         */
        public void deleteNode(int no) {
            if (this.root != null) {
                if (no == this.root.no) {
                    this.root = null;
                }else {
                    this.root.deleteNode(no);
                }
            }else {
                throw new RuntimeException("根节点为空");
            }
        }

        /**
         * 中序线索化
         * @param node 节点
         */
        private void threadedTree(Node node) {
            if (node == null) {
                return;
            }
            threadedTree(node.left);

            // 处理前驱节点
            if (node.left == null) {
                node.left = preNode;
                node.leftType = 1;
            }
            // 处理后继节点
            if (preNode != null && preNode.right == null) {
                preNode.right = node;
                preNode.rightType = 1;
            }
            // 移动 preNode
            preNode = node;
            threadedTree(node.right);
        }

        public void threadedTree() {
            this.threadedTree(root);
        }

        // 遍历线索化二叉树的方法
        public void threadedList() {
            Node node = root;
            while (node != null) {
                // 当 node 的 leftType 为 1，就是左子树最深层
                while (node.leftType == 0) {
                    node = node.left;
                }
                System.out.println(node);
                // 如果当前节点的右指针指向的是后继节点，就一直输出
                while (node.rightType == 1) {
                    node = node.right;
                    System.out.println(node);
                }
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = new Node(1, "tom");
        Node node2 = new Node(3, "jack");
        Node node3 = new Node(6, "smith");
        Node node4 = new Node(8, "mary");
        Node node5 = new Node(10, "king");
        Node node6 = new Node(14, "dim");

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        tree.setRoot(root);

//        System.out.println(node5.left);
        tree.threadedTree();
//        System.out.println(node5.left);
//        System.out.println(node5.right);
        tree.threadedList();
    }
}
