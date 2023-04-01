package AutumnPlan_2023.March.day_3_31;

// @date 2023/3/31
// @time 22:09
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

    /**
     * 前序遍历
     */
    private boolean isValid(TreeNode root, long left, long right){
        if(root == null){
            return true;
        }
        int val = root.val;
        if(val <= left || val >= right){
            return false;
        }
        if(!isValid(root.left, left, val)){
            return false;
        }
        if(!isValid(root.right, val, right)){
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 中序遍历
     */
    long pre = Long.MIN_VALUE;

    public boolean isValidBST_Mid(TreeNode root) {
        if(root == null){
            return true;
        }

        if(!isValidBST_Mid(root.left)){
            return false;
        }

        if(pre >= root.val){
            return false;
        }
        pre = root.val;
        if(!isValidBST_Mid(root.right)){
            return false;
        }
        return true;
    }

    /**
     * 后序遍历
     */
    private long[] isValidPost(TreeNode root){
        if(root == null){
            // 为什么返回这个区间？
            // 解释：这是为了保证在返回了这个区间后，这个判断
            // if(val <= left[1] || val >= right[0]) 是一定不成立的。
            // 避免出现错判
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        }
        long[] left = isValidPost(root.left);
        long[] right = isValidPost(root.right);
        int val = root.val;
        if(val <= left[1] || val >= right[0]){
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        // 最后返回左边的最小值和右边的最大值
        return new long[]{Math.min(left[0], val), Math.max(right[1], val)};
    }

    public boolean isValidBSTPost(TreeNode root) {
        return isValidPost(root)[1] != Long.MAX_VALUE;
    }
}
