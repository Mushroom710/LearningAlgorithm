package AutumnPlan_2023.March.day_3_28;

// @date 2023/3/28
// @time 22:15
// @author zhangzhi
// @description LeetCode 110. 平衡二叉树

public class BalancedBinaryTree {

    /**
     * 要学会怎么在合适的场景使用标记法
     * 如果不是平衡树，返回 -1
     */
    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = getHeight(root.left);
        if(leftDepth == -1){
            return -1;
        }
        int rightDepth = getHeight(root.right);
        if(rightDepth == -1){
            return -1;
        }

        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : Math.max(leftDepth, rightDepth) + 1;

    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
}
