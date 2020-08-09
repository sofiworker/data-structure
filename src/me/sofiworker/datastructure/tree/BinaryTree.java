package me.sofiworker.datastructure.tree;

/**
 * @author sofiworker
 * @date 2020/8/9
 */
public class BinaryTree {

    static class Node {
        int no;
        String name;
        Node left;
        Node right;

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
    }

    static class Tree {
        private Node root;

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
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");

        root.left = node2;
        root.right = node3;
        node3.right = node4;

        tree.setRoot(root);

//        System.out.println("前序遍历：");
//        tree.preOrder();
//        System.out.println("中序遍历：");
//        tree.infixOrder();
//        System.out.println("后序遍历：");
//        tree.postOrder();

//        System.out.println("前序查找：");
//        System.out.println(tree.preFind(12));
//        System.out.println("中序查找：");
//        System.out.println(tree.infixFind(12));
//        System.out.println("后序查找：");
//        System.out.println(tree.postFind(12));

    }
}
