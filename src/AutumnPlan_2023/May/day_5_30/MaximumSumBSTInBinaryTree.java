package AutumnPlan_2023.May.day_5_30;

// @date 2023/5/30
// @time 10:01
// @author zhangzhi
// @description LeetCode 1373. 二叉搜索子树的最大键值和

public class MaximumSumBSTInBinaryTree {
    int ans = 0;

    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int cur = root.val;
        // 小于左边的最大值，大于右边的最小值
        // 不是二叉搜索树
        if(cur <= left[1] || cur >= right[0]){
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int s = left[2] + right[2] + cur;
        ans = Math.max(ans, s);

        return new int[]{Math.min(left[0], cur), Math.max(right[1], cur), s};
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
}
