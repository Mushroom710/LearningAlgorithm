package AutumnPlan_2023.March.day_3_26;

// @date 2023/3/26
// @time 22:10
// @author zhangzhi
// @description 二叉树的三种迭代遍历

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class IterativeTraversal {


    /**
     * 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        TreeNode cur = root;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);      // 中
            if(node.right != null){
                stack.push(node.right);  // 右
            }
            if(node.left != null){
                stack.push(node.left); // 左
            }
        }
        return ans;
    }

    /**
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root ==  null){
            return ans;
        }
        TreeNode cur = root;
        // 要操作的节点和遍历的节点不是一个节点
        while(cur != null || !stack.isEmpty()){
            if(cur != null){ // 先找到最左边的节点
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }
        return ans;
    }

    /**
     * 后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val); // 中
            if(node.left != null){
                stack.push(node.left); // 左
            }
            if(node.right != null){
                stack.push(node.right);  // 右
            }
        }
        Collections.reverse(ans);  // 反转
        return ans;
    }
}
