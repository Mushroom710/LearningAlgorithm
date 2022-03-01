package LeetCode;

import javax.management.MBeanException;

/**
 * @DATE 2022/3/1
 * @Created by zhangzhi
 * @description LeetCode98题 验证二叉搜索树
 * 1.空树也是二叉搜索树。
 * 2.二叉搜索树的左子树的所有结点均小于根结点，右子树所有结点均大于根节点
 */

//二叉搜索树结点
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBinarySearchTree {


    /**
     * @return a
     * @create zhangzhi
     * @date 2022/3/1
     * @time 19:00
    * @description
     * 1.对树进行中序遍历。因为是二叉搜索树，所以根据搜索树性质可知，中序遍历的结果是一个
     * 升序的数组。由此可以判断
     * 2.对上面解法的一种优化，因为是升序的数组，所以只需要比较前继结点和当前结点
     * 3.递归解法。分别找左子树的最大值，右子树的最小值。比较 max>root, min>root
     */
    //中序遍历（错误解题，写错啦。想法是对的，当落地实现出问题了）
    public static boolean solution(TreeNode root){
        return in_order(root,root);
    }
    public static boolean in_order(TreeNode root,TreeNode pre){
        if(root == null){
            return true;
        }
        pre = root;
        in_order(root.left,pre);
        if(root.left!=null&&root.left.val > pre.val){
            return false;
        }
        in_order(root.right,pre);
        if(root.right!=null&&root.right.val < pre.val){
            return false;
        }
        return true;
    }

    //没理解透彻解题方法。编码能力还有待提高
    static long pre;
    public static boolean solution_right(TreeNode root){
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!solution_right(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return solution_right(root.right);
    }

    public static void main(String[] args) {

    }
}
