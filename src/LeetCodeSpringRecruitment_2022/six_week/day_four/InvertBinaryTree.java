package LeetCodeSpringRecruitment_2022.six_week.day_four;

import java.util.Stack;

/**
 * @DATE 2022/4/22
 * @TIME 21:53
 * @Created by zhangzhi
 * @description LeetCode 226 翻转二叉树
 */
public class InvertBinaryTree {

    public static TreeNode solution(TreeNode root){
        if (root == null)return root;
        // 交换左右孩子
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 向左向右递归
        solution(root.left);
        solution(root.right);
        return root;
    }

    /**
     * @create zhangzhi
     * @date 2022/4/22
     * @time 22:18
     * @description 迭代法
     */
    public static TreeNode solution_two(TreeNode root){
        if (root == null)return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            // 交换左右孩子
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            // 左孩子不为 null ，入栈
            if (node.left != null)stack.push(node.left);
            // 右孩子不为 null ，入栈
            if (node.right != null)stack.push(node.right);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
