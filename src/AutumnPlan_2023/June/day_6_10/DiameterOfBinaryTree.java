package AutumnPlan_2023.June.day_6_10;

// @date 2023/6/10
// @time 11:24
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
    int ans = Integer.MIN_VALUE;

    private int dfs(TreeNode root){
        if(root == null){
            return -1;
        }
        int l_dep = dfs(root.left);
        int r_dep = dfs(root.right);
        ans = Math.max(ans, l_dep + r_dep + 2);
        return Math.max(l_dep, r_dep) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
}
