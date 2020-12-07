package g.practice;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 思路：后序遍历结果的最后值是根节点，小于根节点的是左子树，大于根节点的是右子树
 *
 * @author junjun.lei
 * @create 2020-12-03 14:31
 */
public class VerifySequenceOfBst {

    public static void main(String[] args) {

        int[] sequence = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(verifySequenceOfBst(sequence));
    }

    public static boolean verifySequenceOfBst(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private static boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int curIndex = first;
        while (curIndex < last && sequence[curIndex] <= rootVal) {
            curIndex++;
        }
        for (int i = curIndex; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, first, curIndex - 1) && verify(sequence, curIndex, last-1);
    }
}
