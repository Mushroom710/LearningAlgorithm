package AutumnPlan_2023.day_3_27;

// @date 2023/3/27
// @time 22:01
// @author zhangzhi
// @description LeetCode 111. 二叉树的最小深度
// 注意审题：题目中说的是：最小深度是从根节点到最近叶子节点的最短路径上的节点数量。注意是叶子节点。
// 什么是叶子节点，左右孩子都为空的节点才是叶子节点！

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 当一个左子树为空，右不为空，这时并不是最低点
        if(root.left == null){
            return 1 + right;
        }
        // 当一个右子树为空，左不为空，这时并不是最低点
        if(root.right == null){
            return 1 + left;
        }
        // 左右结点都不为空，取最小的
        return 1 + Math.min(left, right);
    }
}
