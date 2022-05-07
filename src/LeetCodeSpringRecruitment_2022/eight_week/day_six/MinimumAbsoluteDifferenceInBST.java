package LeetCodeSpringRecruitment_2022.eight_week.day_six;

import java.util.Stack;

/**
 * @DATE 2022/5/7
 * @TIME 21:44
 * @Created by zhangzhi
 * @description LeetCode 530 题 二叉搜索树的最小绝对差
 */
public class MinimumAbsoluteDifferenceInBST {

    static int min;
    static TreeNode pre;

    /**
     * @create zhangzhi
     * @date 2022/5/7
     * @time 21:52
     * @description 二叉搜索树是有序的，用中序遍历就可以得到一个有序数组
     * 所以，最小绝对差只能出现在两个相邻的元素之间
     */
    public static void recursion(TreeNode root){
        if (root == null)return;
        recursion(root);
        if (pre != null)min = Math.min(min,Math.abs(pre.val - root.val));
        pre = root;
        recursion(root.right);
    }

    public static int solution(TreeNode root){
        min = Integer.MAX_VALUE;
        pre = null;
        recursion(root);
        return min;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/7
     * @time 21:56
     * @description 同样，递归能做的事，栈也能做
     */
    public static int solution_two(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        int ans = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if (pre!= null){
                    ans = Math.min(ans,cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
