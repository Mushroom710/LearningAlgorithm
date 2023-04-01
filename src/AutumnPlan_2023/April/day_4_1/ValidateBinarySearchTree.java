package AutumnPlan_2023.April.day_4_1;

// @date 2023/4/1
// @time 22:19
// @author zhangzhi
// @description LeetCode 98. 验证二叉搜索树

public class ValidateBinarySearchTree {

    private boolean isBST(TreeNode root, long left, long right){
        if(root == null){
            return true;
        }
        if(root.val <= left || root.val >= right){
            return false;
        }
        if(!isBST(root.left, left, root.val)){
            return false;
        }
        return isBST(root.right, root.val, right);
    }

    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

}
