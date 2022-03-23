package LeetCodeSpringRecruitment_2022.second_week.day_three;

/**
 * @DATE 2022/3/23
 * @TIME 16:35
 * @Created by zhangzhi
 * @description LeetCode 101 题 对称的二叉树
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

public class SymmetricTree {

    public static boolean solution(TreeNode root){
        if(root == null){
            return true;
        }

        return dfs(root.left,root.right);
    }

    /**
     * @create zhangzhi
     * @date 2022/3/23
     * @time 16:46
     * @description 第一版
     * 1.无非递归找左子树和右子树是否对称
     * 2.如果 left.val == right.val
     * 那么就递归 func(left.left,right.right) && func(left.right,right.left)
     * 这段代码的意思是：把左右子树又分成一个独立的二叉树，递归看是否对称
     */
    private static boolean dfs(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }
        // 看到一个人的代码，这里还可以稍微优化下
        if(left.val == right.val){
            return dfs(left.left,right.right) && dfs(left.right,right.left);
        }
        return false;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/23
     * @time 16:46
     * @description 对上面的写法一种更简洁的版本
     */
    private static boolean dfs_two(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null || left.val != right.val){
            return false;
        }
        return dfs_two(left.left,right.right) && dfs_two(left.right,right.left);
    }

    public static void main(String[] args) {

    }
}
