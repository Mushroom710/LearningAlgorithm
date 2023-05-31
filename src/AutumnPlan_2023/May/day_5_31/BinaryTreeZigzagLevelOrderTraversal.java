package AutumnPlan_2023.May.day_5_31;

import java.util.*;

// @date 2023/5/31
// @time 9:33
// @author zhangzhi
// @description LeetCode 103. 二叉树的锯齿形层序遍历
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> dq = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean even = false;
        dq.addLast(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> vals = new ArrayList<>(size);
            for(int i = 0; i < size; i++){
                TreeNode node = dq.pollFirst();
                vals.add(node.val);
                if(node.left != null){
                    dq.addLast(node.left);
                }
                if(node.right != null){
                    dq.addLast(node.right);
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
