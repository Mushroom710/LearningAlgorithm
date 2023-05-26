package AutumnPlan_2023.May.day_5_26;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// @date 2023/5/26
// @time 10:14
// @author zhangzhi
// @description LeetCode 113. 路径总和 II
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

class Pack{
    TreeNode node;
    int t;
    List<Integer> list;
    Pack(TreeNode node, int t){
        this.node = node;
        this.t = t;
        this.list = new ArrayList<>();
    }
    Pack(){}
}
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<Pack> stack = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        Pack p = new Pack(root, targetSum - root.val);
        p.list.add(root.val);
        stack.push(p);
        while(!stack.isEmpty()){
            p = stack.pop();
            if(p.node.left == null && p.node.right == null && p.t == 0){
                ans.add(new ArrayList<>(p.list));
            }
            if(p.node.right != null){
                Pack right = new Pack(p.node.right, p.t - p.node.right.val);
                right.list.addAll(p.list);
                right.list.add(p.node.right.val);
                stack.push(right);
            }
            if(p.node.left != null){
                Pack left = new Pack(p.node.left, p.t - p.node.left.val);
                left.list.addAll(p.list);
                left.list.add(p.node.left.val);
                stack.push(left);
            }
        }
        return ans;
    }
}
