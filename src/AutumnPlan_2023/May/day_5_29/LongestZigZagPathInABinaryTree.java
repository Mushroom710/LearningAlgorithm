package AutumnPlan_2023.May.day_5_29;

import java.util.ArrayList;
import java.util.List;

// @date 2023/5/29
// @time 9:42
// @author zhangzhi
// @description LeetCode 1372. 二叉树中的最长交错路径

public class LongestZigZagPathInABinaryTree {
    int ans = 0;

    private int[] dfs(TreeNode root){
        if(root == null){
            // lr,rl
            return new int[]{-1, -1};
        }

        int lr = dfs(root.left)[1] + 1;
        int rl = dfs(root.right)[0] + 1;

        ans = Math.max(ans, Math.max(lr, rl));
        return new int[]{lr, rl};
    }

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return ans;
    }
}
