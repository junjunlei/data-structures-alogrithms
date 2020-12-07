package g.binarytree;

import java.util.Arrays;

/**
 * @author junjun.lei
 * @create 2020-12-02 11:15
 */
public class Test {
    public static void main(String[] args) {
        /**
         *        5
         *    3       8
         *  2   4   6   9
         */
        TreeNode root = new TreeNode(5);
        BinaryTree tree=new BinaryTree(root);
        tree.insert(3);
        tree.insert(8);
        tree.insert(4);
        tree.insert(6);
        tree.insert(2);
        tree.insert(9);
        System.out.println("先序遍历递归");
        tree.preOrder(root);
        System.out.println();
        System.out.println("先序遍历非递归");
        tree.pre(root);

        System.out.println("中序遍历递归");
        tree.inOrder(root);
        System.out.println();
        System.out.println("中序遍历非递归");
        tree.in(root);

        System.out.println();
        System.out.println("后序遍历递归");
        tree.postOrder(root);
        System.out.println();
        System.out.println("后序遍历非递归");
        tree.post(root);

        System.out.println();
        System.out.println("从上到下打印二叉树搜索树");
        tree.bfs(root);
        System.out.println();
    }
}
