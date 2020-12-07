package g.binarytree;

/**
 * 树节点
 *
 * @author junjun.lei
 * @create 2020-12-02 8:54
 */
public class TreeNode {
    /**
     * 关键字
     */
    public int val;
    /**
     * 左子树
     */
    public TreeNode left;
    /**
     * 右子树
     */
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
