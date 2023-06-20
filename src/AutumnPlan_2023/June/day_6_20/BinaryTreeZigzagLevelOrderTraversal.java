package AutumnPlan_2023.June.day_6_20;

import java.util.*;

// @date 2023/6/20
// @time 10:45
// @author zhangzhi
// @description LeetCode 103. 二叉树的锯齿形层序遍历
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean even = false;
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> vals = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = deque.pollFirst();
                vals.add(node.val);
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
            }
            if(even){
                Collections.reverse(vals);
            }
            ans.add(vals);
            even = !even;
        }
        return ans;
    }
}
