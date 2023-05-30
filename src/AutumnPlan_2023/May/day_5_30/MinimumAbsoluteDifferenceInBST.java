package AutumnPlan_2023.May.day_5_30;

// @date 2023/5/30
// @time 10:00
// @author zhangzhi
// @description LeetCode 530. 二叉搜索树的最小绝对差

public class MinimumAbsoluteDifferenceInBST {

    TreeNode pre = null;
    int ans = Integer.MAX_VALUE;

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);

        if(pre != null){
            ans = Math.min(ans, root.val - pre.val);
        }
        pre = root;

        dfs(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }
}
