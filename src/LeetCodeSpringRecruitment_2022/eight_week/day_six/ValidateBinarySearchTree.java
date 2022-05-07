package LeetCodeSpringRecruitment_2022.eight_week.day_six;

import java.util.Stack;

/**
 * @DATE 2022/5/7
 * @TIME 21:01
 * @Created by zhangzhi
 * @description LeetCode 98 题 验证二叉搜索树
 */

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

    static long min;

    /**
     * @create zhangzhi
     * @date 2022/5/7
     * @time 22:24
     * @description 递归法 --- 通过找一个不满足 BST 条件的节点
     */
    public static boolean solution(TreeNode root){
        if (root == null)return true;
        boolean left = solution(root.left);
        if (min < root.val){
            min = root.val;
        }else {
            return false;
        }
        boolean right = solution(root.right);
        return left && right;
    }

    static TreeNode pre;

    /**
     * @create zhangzhi
     * @date 2022/5/7
     * @time 22:23
     * @description 递归法 --- 通过保存前一个节点
     */
    public static boolean solution_two(TreeNode root){
        if (root == null)return true;
        boolean left = solution_two(root.left);
        if (pre != null && pre.val >= root.val)return false;
        pre = root;
        boolean right = solution_two(root.right);
        return left && right;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/7
     * @time 22:23
     * @description 迭代法
     */
    public static boolean solution_three(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if (pre != null && pre.val >= cur.val)return false;
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }

    public static boolean isValidBST(TreeNode root){
//        min = Long.MIN_VALUE;
//        return solution(root);
        pre = null;
        return solution_two(root);
    }

    public static void main(String[] args) {

    }
}
