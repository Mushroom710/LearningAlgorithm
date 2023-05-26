package AutumnPlan_2023.May.day_5_26;

// @date 2023/5/26
// @time 11:09
// @author zhangzhi
// @description LeetCode 112. 路径总和
public class PathSum {
    private boolean dfs(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return targetSum - root.val == 0;
        }
        boolean l = dfs(root.left, targetSum - root.val);
        boolean r = dfs(root.right, targetSum - root.val);
        return l || r;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }
}
