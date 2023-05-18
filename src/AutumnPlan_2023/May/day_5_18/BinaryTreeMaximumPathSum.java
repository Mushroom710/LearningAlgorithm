package AutumnPlan_2023.May.day_5_18;

// @date 2023/5/18
// @time 10:27
// @author zhangzhi
// @description LeetCode 124. 二叉树中的最大路径和
public class BinaryTreeMaximumPathSum {
    private int ans;

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right + root.val);
        return Math.max(Math.max(left, right) + root.val, 0);
    }

    public int maxPathSum(TreeNode root) {
        this.ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
}
