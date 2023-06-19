package AutumnPlan_2023.June.day_6_19;

// @date 2023/6/19
// @time 10:48
// @author zhangzhi
// @description LeetCode 230. 二叉搜索树中第K小的元素
public class KthSmallestElementInABST {
    int ans = -1;
    int idx = 0;
    private void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }
        dfs(root.left, k);
        idx += 1;
        if(idx == k){
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
}
