package AutumnPlan_2023.day_3_28;

// @date 2023/3/28
// @time 22:14
// @author zhangzhi
// @description LeetCode 222. 完全二叉树的节点个数

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

public class CountCompleteTreeNodes {

    /**
     * 利用完全二叉树的性质
     */
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0;
        int rightDepth = 0;
        while(left != null){
            left = left.left;
            leftDepth += 1;
        }
        while(right != null){
            right = right.right;
            rightDepth += 1;
        }
        if(leftDepth == rightDepth){
            return (2 << leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
