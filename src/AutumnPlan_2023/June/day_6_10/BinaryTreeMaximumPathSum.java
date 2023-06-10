package AutumnPlan_2023.June.day_6_10;

// @date 2023/6/10
// @time 11:25
// @author zhangzhi
// @description LeetCode 124. 二叉树中的最大路径和
public class BinaryTreeMaximumPathSum {
    int ans = Integer.MIN_VALUE;

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans = Math.max(ans, l + r + root.val);
        return Math.max(0, Math.max(l, r) + root.val);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
}
