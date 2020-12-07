package g.practice;

import g.binarytree.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * {8,8,#,9,#,2,#,5},{8,9,#,2}
 * true
 * <p>
 * 思路：若根节点相等，利用递归比较他们的子树是否相等，若根节点不相等，利用递归分别再从左右子树中查找
 *
 * @author junjun.lei
 * @create 2020-12-03 13:38
 */
public class HasSubtree {

    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return doesTree1HasTree2(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    public static boolean doesTree1HasTree2(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return doesTree1HasTree2(node1.left, node2.left) && doesTree1HasTree2(node1.right, node2.right);
    }
}
