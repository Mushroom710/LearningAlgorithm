package AutumnPlan_2023.day_3_29;

// @date 2023/3/29
// @time 22:13
// @author zhangzhi
// @description LeetCode 404. 左叶子之和

import java.util.Stack;

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

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null && node.left.left == null && node.left.right == null){
                sum += node.left.val;
            }
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return sum;
    }
}
