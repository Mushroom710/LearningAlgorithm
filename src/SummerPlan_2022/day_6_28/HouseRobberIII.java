package SummerPlan_2022.day_6_28;

/**
 * @DATE 2022/6/28
 * @TIME 15:48
 * @Created by zhangzhi
 * @description LeetCode 337 题 打家劫舍 III
 */

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

public class HouseRobberIII {

    public static int rob(TreeNode root) {
        int[] re = robTree(root);
        return Math.max(re[0],re[1]);
    }
    // 长度为2的数组，0：不偷，1：偷
    private static int[] robTree(TreeNode cur){
        if (cur == null)return new int[]{0,0};
        int[] left = robTree(cur.left);
        int[] right = robTree(cur.right);
        // 偷cur
        int val1 = cur.val + left[0] + right[0];
        // 不偷cur
        int val2 = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return new int[]{val2,val1};
    }

    public static void main(String[] args) {

    }
}
