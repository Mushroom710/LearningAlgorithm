package AutumnPlan_2023.June.day_6_17;

// @date 2023/6/17
// @time 10:15
// @author zhangzhi
// @description LeetCode 1026. 节点与其祖先之间的最大差值
public class MaximumDifferenceBetweenNodeAndAncestor {
    int ans = -1;

    private void dfs(TreeNode root, int min, int max){
        if(root == null){
            return;
        }
        int x = root.val;
        ans = Math.max(ans, Math.max(Math.abs(x - min), Math.abs(x - max)));
        min = Math.min(x, min);
        max = Math.max(x, max);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }
}
