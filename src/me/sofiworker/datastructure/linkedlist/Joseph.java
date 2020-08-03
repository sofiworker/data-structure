package me.sofiworker.datastructure.linkedlist;

/**
 * @author sofiworker
 * @date 2020/8/3
 *
 * 约瑟夫环形链表
 */
public class Joseph {

    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    static class CycleLinkedList {

        private Node first;

        public void createList(int num) {
            if (num < 1) {
                throw new RuntimeException("数值不能小于1");
            }
            Node cur = null;
            for (int i = 1; i <= num; i++) {
                Node node = new Node(i);
                if (i == 1) {
                    first = node;
                    first.next = first;
                    cur = first;
                }else {
                    cur.next = node;
                    node.next = first;
                    cur = node;
                }
            }
        }

        public void list() {
            if (first == null) {
                throw new RuntimeException("链表为空");
            }
            Node temp = first;
            while (true) {
                System.out.printf("当前节点的值：%d\n", temp.val);
                if (temp.next == first) {
                    break;
                }
                temp = temp.next;
            }
        }

        /**
         * 出圈
         * @param start 开始的位置
         * @param count 经过的个数
         * @param nodeNum 节点的总数
         */
        public void out(int start, int count, int nodeNum) {
            if (first == null || start < 1 || start > nodeNum || count < 1) {
                throw new RuntimeException("参数异常");
            }
            Node help = first;
            for (int i = 0; i < start - 1; i++) {
                help = help.next;
                first = first.next;
            }
            while (help != first.next) {
                for (int i = 0; i < count - 1; i++) {
                    first = first.next;
                }
                for (int i = 0; i < count - 2; i++) {
                    help = help.next;
                }
                System.out.printf("出圈的值为：%d\n", first.val);
                help.next = first.next;
                help = first.next;
                first = first.next;
            }
            System.out.printf("剩下的值为：%d\n", first.val);
        }

    }

    public static void main(String[] args) {
        CycleLinkedList linkedList = new CycleLinkedList();
        linkedList.createList(5);
        linkedList.list();
        System.out.println("===============");
        linkedList.out(1, 2, 5);
    }
}
