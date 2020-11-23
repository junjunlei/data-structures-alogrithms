package e.recursion;

/**
 * 三角数字
 * <p>
 * 1 3 6 10 15 21
 *
 * @author junjun.lei
 * @create 2020-11-17 13:41
 */
public class Triangle {
    public static void main(String[] args) {
        System.out.println(triangle(6));
        System.out.println(triangleRecursion(7));
    }

    /**
     * 非递归
     * 1=1
     * 3=1+2
     * 6=1+2+3
     * 10=1+2+3+4
     * 15=1+2+3+4+5
     *
     * @param n
     * @return
     */
    public static int triangle(int n) {
        int total = 0;
        while (n > 0) {
            total += n;
            --n;
        }
        return total;
    }

    /**
     * 递归
     * 第n-1项+n
     *
     * @param n
     * @return
     */
    public static int triangleRecursion(int n) {
        if(n==1){
            return 1;
        }else {
            return n+triangleRecursion(n-1);
        }
    }
}
