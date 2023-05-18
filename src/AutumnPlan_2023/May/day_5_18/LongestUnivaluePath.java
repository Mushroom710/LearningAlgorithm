package AutumnPlan_2023.May.day_5_18;

// @date 2023/5/18
// @time 10:28
// @author zhangzhi
// @description LeetCode 687. 最长同值路径
public class LongestUnivaluePath {
    private int ans;

    private int dfs(TreeNode root){
        if(root == null){
            return -1;
        }
        int l_deep = dfs(root.left) + 1;
        int r_deep = dfs(root.right) + 1;
        if(root.left != null && root.left.val != root.val){
            l_deep = 0;
        }
        if(root.right != null && root.right.val != root.val){
            r_deep = 0;
        }
        ans = Math.max(ans, l_deep + r_deep);
        return Math.max(l_deep, r_deep);
    }

    public int longestUnivaluePath(TreeNode root) {
        this.ans = 0;
        dfs(root);
        return ans;
    }
}
