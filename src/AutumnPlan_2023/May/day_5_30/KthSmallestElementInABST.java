package AutumnPlan_2023.May.day_5_30;

// @date 2023/5/30
// @time 9:59
// @author zhangzhi
// @description LeetCode 230. 二叉搜索树中第K小的元素

public class KthSmallestElementInABST {
    TreeNode pre = null;
    int k;
    int ans = -1;

    private void dfs(TreeNode root){
        if(pre != null){
            if(k == 0){
                ans = pre.val;
                return;
            }
        }
        if(root == null){
            return;
        }
        dfs(root.left);
        k--;
        pre = root;
        dfs(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;

        dfs(root);
        return ans;
    }
}
