package me.sofiworker.datastructure.linkedlist;

/**
 * @author sofiworker
 * @date 2020/8/2
 *
 * 单链表
 */
public class SingleLinkedList {

    static class Node {

        public int no;
        public String name;
        public String nickName;
        public Node next;

        public Node(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }

    private final Node head = new Node(0, "", "");
    private Node tail = head;

    public void add(Node node) {
        tail.next = node;
        tail = node;
    }

    public void addByOrder(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                // 当链表为空或找插入的节点判断为最后的节点时，直接赋值
                temp.next = node;
                break;
            }
            if (temp.next.no > node.no) {
                node.next = temp.next;
                temp.next = node;
                break;
            }else if (temp.next.no == node.no) {
                throw new RuntimeException("当前节点已经存在");
            }
            temp = temp.next;
        }
    }

    public void updateNode(Node node) {
        Node temp = head.next;
        if (temp == null) {
            throw new RuntimeException("链表为空");
        }
        boolean modified = false;
        while (true) {
            if (temp.no == node.no) {
                temp.name = node.name;
                temp.nickName = node.nickName;
                modified = true;
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (!modified) {
            throw new RuntimeException("该节点不存在！");
        }
    }

    public void list() {
        if (head.next == null) {
            throw new RuntimeException("链表为空");
        }
        Node temp = head.next;
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }

    public void delNode(Node node) {
        Node temp = head;
        if (temp.next == null) {
            throw new RuntimeException("链表为空");
        }
        boolean isDel = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == node.no) {
                isDel = true;
                break;
            }
            temp = temp.next;
        }
        if (isDel) {
            temp.next = temp.next.next;
        }else {
            throw new RuntimeException("该节点不存在");
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
//        singleLinkedList.add(node3);
//        singleLinkedList.add(node4);
        singleLinkedList.list();

        System.out.println("11111111");
        singleLinkedList.delNode(node4);
        singleLinkedList.list();
//        singleLinkedList.addByOrder(node2);
//        singleLinkedList.addByOrder(node1);
//        singleLinkedList.addByOrder(node4);
//        singleLinkedList.addByOrder(node3);
//        singleLinkedList.list();
    }
}
