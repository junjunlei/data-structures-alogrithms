package c.stack;

/**
 * @author junjun.lei
 * @create 2020-11-10 11:16
 */
public class StackTest {
    public static void main(String[] args) {
        StackA stackA = new StackA(5);
        stackA.push(1);
        stackA.push(2);
        stackA.push(3);
        stackA.push(4);
        System.out.println(stackA.pop());
    }
}
