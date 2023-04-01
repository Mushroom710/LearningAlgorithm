package AutumnPlan_2023.April.day_4_1;

// @date 2023/4/1
// @time 22:19
// @author zhangzhi
// @description LeetCode 530. 二叉搜索树的最小绝对差

import java.util.Stack;

public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int ans = Integer.MAX_VALUE;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(pre != null){
                    ans = Math.min(Math.abs(pre.val - cur.val), ans);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return ans;
    }
}
