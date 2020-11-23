package e.recursion;

/**
 * 汉诺塔问题
 * <p>
 * 解决思路 拆分成子塔
 *
 * @author junjun.lei
 * @create 2020-11-23 15:34
 */
public class Tower {
    public static void main(String[] args) {
        doTowers(5,'A','B','C');
    }

    public static void doTowers(int n, char from, char inter, char to) {
        if (n == 1) {
            System.out.println("盘 " + n + " 从 :" + from + " 移到 ：" + to);
        } else {
            //将子塔移动到中介inter
            doTowers(n - 1, from, to, inter);
            System.out.println("盘 " + n + " 从 :" + from + " 移到 ：" + to);
            //将剩余的盘子移动到to
            doTowers(n - 1, inter, from, to);
        }
    }
}
