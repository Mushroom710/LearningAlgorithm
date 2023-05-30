package AutumnPlan_2023.May.day_5_30;

// @date 2023/5/30
// @time 10:01
// @author zhangzhi
// @description LeetCode 700. 二叉搜索树中的搜索

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        if(left != null){
            return left;
        }
        return searchBST(root.right, val);
    }
}
