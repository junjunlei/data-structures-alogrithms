package g.practice;

import g.binarytree.TreeNode;

/**
 * 二叉树镜像
 * <p>
 * 思路：递归求解
 *
 * @author junjun.lei
 * @create 2020-12-03 14:18
 */
public class Mirror {
    public static void main(String[] args) {
        /**
         *        5
         *    3       8
         *  2   4   6   9
         */
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        mirror(root);
    }

    public static void mirror(TreeNode root) {
        //递归翻转
        TreeNode temp;
        if (root != null) {
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) {
                mirror(root.left);
            }
            if (root.right != null) {
                mirror(root.right);
            }
        }
    }
}
