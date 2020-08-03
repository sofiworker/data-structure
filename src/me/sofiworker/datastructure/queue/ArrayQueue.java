package me.sofiworker.datastructure.queue;

/**
 * @author sofiworker
 * @date 2020/8/2
 *
 * 数组模拟队列的实现
 */
public class ArrayQueue {

    //存放数据的数组
    private final int[] data;
    //队列的长度
    private final int maxSize;
    //队列的头部，指向头一个元素的前一个位置
    private int front;
    //队列的尾部
    private int rear;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.data = new int[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addElement(int element) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        rear++;
        data[rear] = element;
    }

    public int removeElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return data[front];
    }

    public void showAllElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < rear; i++) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }

    public int showHeadElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return data[front + 1];
    }
}

class T {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.addElement(3);
        queue.addElement(4);
        queue.addElement(5);
        queue.showAllElement();
        System.out.println(queue.showHeadElement());
        queue.showAllElement();
        System.out.println(queue.removeElement());
        queue.showAllElement();
        System.out.println(queue.showHeadElement());
    }
}