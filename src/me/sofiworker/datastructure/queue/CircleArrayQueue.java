package me.sofiworker.datastructure.queue;

/**
 * @author sofiworker
 * @date 2020/8/2
 *
 * 使用数组实现环形队列
 */
public class CircleArrayQueue {


    //存放数据的数组
    private final int[] data;
    //队列的长度
    private final int maxSize;
    //队列的头部，指向头一个元素
    private int front;
    //队列的尾部，初始值为 0
    private int rear;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize + 1;
        this.data = new int[maxSize + 1];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addElement(int element) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        data[rear] = element;
        rear = (rear + 1) % maxSize;
    }

    public int removeElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int val = data[front];
        front = (front + 1) % maxSize;
        return val;
    }

    public void showAllElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("%d\t", data[i % maxSize]);
        }
        System.out.println();
    }

    /**
     * 求当前有效元素的个数
     * @return 个数
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return data[front];
    }
}

class Test {

    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);
        queue.addElement(1);
        queue.addElement(2);
        queue.addElement(3);
        queue.showAllElement();
        System.out.println(queue.headElement());
        System.out.println(queue.size());
        queue.showAllElement();
        System.out.println(queue.removeElement());
        queue.addElement(5);
        queue.showAllElement();
    }
}
