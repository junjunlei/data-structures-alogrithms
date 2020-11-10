package c.stack;

/**
 * 栈
 * <p>
 * 数组实现栈
 * <p>
 * 思路：容量capacity 存储元素的数组storeArray 栈顶元素 top
 *
 * @author junjun.lei
 * @create 2020-11-10 11:04
 */
public class StackA {

    /**
     * 栈容量
     */
    private int capacity;
    /**
     * 存储数据的数组
     */
    private int[] storeArray;
    /**
     * 栈顶元素下标
     */
    private int top;

    public StackA(int capacity) {
        this.capacity = capacity;
        this.storeArray = new int[capacity];
        this.top = -1;
    }

    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("栈已满");
        }
        storeArray[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return storeArray[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}
