package AutumnPlan_2023.June.day_6_11;

// @date 2023/6/11
// @time 10:05
// @author zhangzhi
// @description LeetCode 337. 打家劫舍 III
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
public class HouseRobberIII {
    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int rob = l[1] + r[1] + root.val;
        int not_rob = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{rob, not_rob};
    }

    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }
}
