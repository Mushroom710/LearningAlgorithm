package AutumnPlan_2023.June.day_6_19;

// @date 2023/6/19
// @time 10:47
// @author zhangzhi
// @description LeetCode 98. 验证二叉搜索树
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
public class ValidateBinarySearchTree {
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(pre != null && pre.val >= root.val){
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }
}
