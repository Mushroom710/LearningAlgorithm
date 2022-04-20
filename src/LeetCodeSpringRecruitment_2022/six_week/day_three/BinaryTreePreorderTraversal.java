package LeetCodeSpringRecruitment_2022.six_week.day_three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @DATE 2022/4/20
 * @TIME 21:39
 * @Created by zhangzhi
 * @description LeetCode 144 题 二叉树的前序遍历
 * 这次就用迭代法
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePreorderTraversal {

    public static List<Integer> solution(TreeNode root){
        if(root == null)return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            list.add(top.val);
            if (top.right != null)stack.push(top.right);
            if (top.left != null)stack.push(top.left);
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
