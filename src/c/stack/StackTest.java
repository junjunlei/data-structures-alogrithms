package c.stack;

import java.util.Stack;

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

        String s1 = "[]{}()";
        String s2 = "[(})]{";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));

        String s3 = "abcde";

        System.out.println(reverseStr(s3));
    }

    /**
     * 括号匹配  []{}() true  [(})]{ false
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 单词反转
     *
     * @param s
     * @return
     */
    public static String reverseStr(String s) {
        Stack<Character> stack = new Stack<>();
        String out = "";
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            out += stack.pop();
        }
        return out;
    }
}
