package me.sofiworker.datastructure.stack;

/**
 * @author sofiworker
 * @date 2020/8/3
 *
 * 数组实现栈
 */
public class ArrayStack<T> {

    private final Object[] data;
    private final int maxSize;
    // 栈顶指针
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Object[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(T el) {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        top++;
        data[top] = el;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        Object val = data[top];
        top--;
        return (T)val;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(data[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        ArrayStack<Integer> stack = new ArrayStack<>(5);
//        stack.push(1);
//        stack.push(5);
//        stack.list();
//        System.out.println(stack.pop());


    }
}
