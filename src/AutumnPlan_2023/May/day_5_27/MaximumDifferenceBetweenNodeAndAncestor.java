package AutumnPlan_2023.May.day_5_27;

// @date 2023/5/27
// @time 10:48
// @author zhangzhi
// @description LeetCode 1026. 节点与其祖先之间的最大差值
public class MaximumDifferenceBetweenNodeAndAncestor {
    private int dfs(TreeNode root, int min, int max){
        if(root == null){
            return 0;
        }
        int ans = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        ans = Math.max(ans, dfs(root.left, min, max));
        ans = Math.max(ans, dfs(root.right, min, max));
        return ans;
    }

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
}
