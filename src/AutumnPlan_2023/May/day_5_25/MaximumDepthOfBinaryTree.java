package AutumnPlan_2023.May.day_5_25;

// @date 2023/5/25
// @time 10:09
// @author zhangzhi
// @description LeetCode 104. 二叉树的最大深度

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

class Pack{
    TreeNode node;
    int val;
    Pack(TreeNode node, int val){
        this.node = node;
        this.val = val;
    }
}

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<Pack> stack = new Stack<>();
        int ans = 0;
        stack.push(new Pack(root, 1));
        while(!stack.isEmpty()){
            Pack p = stack.pop();
            ans = Math.max(p.val, ans);
            if(p.node.right != null){
                stack.push(new Pack(p.node.right, p.val + 1));
            }
            if(p.node.left != null){
                stack.push(new Pack(p.node.left, p.val + 1));
            }
        }
        return ans;
    }
}
