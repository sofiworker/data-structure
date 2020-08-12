package me.sofiworker.datastructure.tree;

/**
 * @author sofiworker
 * @date 2020/8/12
 */
public class BinarySortTree {

    static class Node {
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

        public void add(Node node) {
            if (node == null) {
                return;
            }
            if (node.val < this.val) {
                if (this.left == null) {
                    this.left = node;
                }else {
                    this.left.add(node);
                }
            }else {
                if (this.right == null) {
                    this.right = node;
                }else {
                    this.right.add(node);
                }
            }
        }

        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this.val);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        /**
         * 查找要删除的节点
         * @param val 查找的值
         * @return 删除的节点
         */
        public Node searchNode(int val) {
            if (val == this.val) {
                return this;
            }else if (val < this.val) {
                if (this.left == null) {
                    return null;
                }
                return this.left.searchNode(val);
            }else {
                if (this.right == null) {
                    return null;
                }
                return this.right.searchNode(val);
            }
        }

        /**
         * 删除节点的父节点
         * @param val 查找的值
         * @return 删除的节点的父节点
         */
        public Node searchParent(int val) {
            if ((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)) {
                return this;
            }else {
                if (val < this.val && this.left != null) {
                    return this.left.searchParent(val);
                }else if (val >= this.val && this.right != null) {
                    return this.right.searchParent(val);
                }else {
                    return null;
                }
            }
        }
    }

    static class Tree {
        private Node root;

        public void add(Node node) {
            if (root == null) {
                root = node;
            }else {
                root.add(node);
            }
        }

        public void infixOrder() {
            if (root != null) {
                root.infixOrder();
            }else {
                throw new RuntimeException("根节点为空");
            }
        }

        public Node search(int val) {
            if (root == null) {
                return null;
            }else {
                return root.searchNode(val);
            }
        }

        public Node searchParent(int val) {
            if (root == null) {
                return null;
            }else {
                return root.searchParent(val);
            }
        }

        /**
         * @param node 右子树的根节点
         * @return 右子树中的最小值
         */
        public int delRightTreeMin(Node node) {
            Node target = node;
            while (target.left != null) {
                target = target.left;
            }
            delNode(target.val);
            return target.val;
        }

        public void delNode(int val) {
            if (root == null) {
                return;
            }else {
                Node target = search(val);
                if (target == null) {
                    return;
                }
                if (root.left == null && root.right == null) {
                    root = null;
                    return;
                }
                Node parent = searchParent(val);
                // 删除叶子节点
                if (target.left == null && target.right == null) {
                    if (parent.left != null && parent.left.val == target.val) {
                        parent.left = null;
                    }else if (parent.right != null && parent.right.val == target.val) {
                        parent.right = null;
                    }
                    return;
                    // 删除有左右子树的节点
                }else if (target.left != null && target.right != null) {
                    target.val = delRightTreeMin(target.right);
                }else {
                    // 删除只有一个子树的节点
                    if (target.left != null) {
                        if (parent != null) {
                            if (parent.left.val == val) {
                                parent.left = target.left;
                            }else {
                                parent.right = target.left;
                            }
                        }else {
                            root = target;
                        }
                    }else {
                        if (parent != null) {
                            if (parent.left.val == val) {
                                parent.left = target.right;
                            }else {
                                parent.right = target.right;
                            }
                        }else {
                            root = target;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 3, 10, 12, 5, 1, 9};
        Tree tree = new Tree();
        for (int i : a) {
            tree.add(new Node(i));
        }
        tree.infixOrder();

        tree.delNode(3);
        System.out.println("----");
        tree.infixOrder();
    }
}
