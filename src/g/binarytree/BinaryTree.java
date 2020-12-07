package g.binarytree;

import javax.xml.transform.Source;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉搜索树
 * <p>
 * 二叉搜索树容易线性化（变成链表），所以有了红黑树（自平衡二叉搜索树）
 *
 * @author junjun.lei
 * @create 2020-12-02 9:02
 */
public class BinaryTree {
    /**
     * 根节点
     */
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    /**
     * 查找节点
     *
     * @param key
     * @return
     */
    public TreeNode find(int key) {
        TreeNode cur = root;
        while (cur.val != key) {
            if (key < cur.val) {
                cur = cur.left;
            }
            if (key > cur.val) {
                cur = cur.right;
            }
            if (cur == null) {
                return null;
            }
        }
        return cur;
    }

    /**
     * 新增节点
     * <p>
     * 向左或者向右寻找一个空位置，插入
     *
     * @param key
     */
    public void insert(int key) {
        TreeNode treeNode = new TreeNode(key);
        if (root == null) {
            root = treeNode;
        } else {
            TreeNode cur = root;
            TreeNode parent;
            while (true) {
                parent = cur;
                if (key < cur.val) {
                    cur = cur.left;
                    if (cur == null) {
                        parent.left = treeNode;
                        return;
                    }
                } else if (key > cur.val) {
                    cur = cur.right;
                    if (cur == null) {
                        parent.right = treeNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 删除节点
     * <p>
     * 考虑三种情况
     * <p>
     * 1.该节点是叶子节点
     * <p>
     * 2.该节点有一个节点
     * <p>
     * 3.该节点有两个子节点
     *
     * @param key
     * @return
     */
    public boolean delete(int key) {

        TreeNode cur = root;
        TreeNode parent = root;
        //判断是左子节点还是右子节点
        boolean isLeftChild = true;

        //1.找到该节点
        while (key != cur.val) {
            parent = cur;
            if (key < cur.val) {
                isLeftChild = true;
                cur = cur.left;
            } else {
                isLeftChild = false;
                cur = cur.right;
            }
            if (cur == null) {
                return false;
            }
        }

        //2.如果是叶子节点
        if (cur.left == null && cur.right == null) {
            //需判断是不是根节点
            if (cur == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (cur.left == null) {
            //一个子节点
            if (cur == root) {
                root = cur.right;
            } else if (isLeftChild) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            //一个子节点
            if (cur == root) {
                root = cur.left;
            } else if (isLeftChild) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        }
        //两个节点的删除，比较麻烦
        return false;
    }

    /**
     * 先序遍历递归
     */
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 先序遍历非递归
     * 栈模拟递归
     * 先将左子节点压栈并打印，然后处理右子节点
     *
     * @param root
     */
    public void pre(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            //先将根节点和左子树不断压栈并打印，直到null
            while (root != null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }
            //处理栈顶左子树的右子树
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历递归
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    /**
     * 中序遍历非递归
     * 先把左子节点压栈，然后打印左子节点，再处理右子节点
     *
     * @param root
     */
    public void in(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.print(node.val + " ");
                root = node.right;
            }
        }
    }

    /**
     * 后序遍历递归
     *
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    /**
     * 后序遍历非递归
     * <p>
     * 两个栈
     * <p>
     * 栈1 根 左 右的顺序压栈
     * <p>
     * 栈2 根 右 左的顺序压栈
     * <p>
     * 这样就报证输出的时候，先左子树，再右子树，最后根节点的顺序
     *
     * @param root
     */
    public void post(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    /**
     * 从上到下打印二叉树（广度优先算法）
     *
     * @param root
     */
    public void bfs(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null){
                queue.addLast(node.left);
            }
            if(node.right!=null){
                queue.addLast(node.right);
            }
        }
    }
}
