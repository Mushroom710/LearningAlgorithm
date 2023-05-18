package AutumnPlan_2023.May.day_5_18;

// @date 2023/5/18
// @time 10:26
// @author zhangzhi
// @description LeetCode 543. 二叉树的直径

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
public class DiameterOfBinaryTree {
    private int ans;

    private int dfs(TreeNode root){
        if(root == null){
            return -1;
        }
        int l_deep = dfs(root.left);
        int r_deep = dfs(root.right);
        ans = Math.max(ans, l_deep + r_deep + 2);
        return Math.max(l_deep, r_deep) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        this.ans = 0;
        dfs(root);
        return ans;
    }
}
