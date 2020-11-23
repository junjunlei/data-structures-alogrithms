package e.recursion;

/**
 * 阶乘
 * 1*1
 * 2*1
 * 3*2*1
 * 4*3*2*1
 * <p>
 * n的阶乘=n*factorial(n-1)
 *
 * @author junjun.lei
 * @create 2020-11-17 14:02
 */
public class Factorial {
    public static void main(String[] args) {

        System.out.println(factorial(5));
        System.out.println(factorialRecursion(5));
    }

    /**
     * n的阶乘 非递归
     * <p>
     * 5*4*3*2*1
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 0) {
            //0的阶乘为1
            return 1;
        }
        int factorial = 1;
        while (n > 0) {
            factorial = factorial * n;
            --n;
        }
        return factorial;
    }

    /**
     * 阶乘递归
     * n的阶乘=n*剩下数字的阶乘和
     *
     * @param n
     * @return
     */
    public static int factorialRecursion(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorialRecursion(n - 1);
        }
    }

}
