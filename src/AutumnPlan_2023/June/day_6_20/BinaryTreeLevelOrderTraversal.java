package AutumnPlan_2023.June.day_6_20;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// @date 2023/6/20
// @time 10:43
// @author zhangzhi
// @description LeetCode 102. 二叉树的层序遍历
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = deque.pollFirst();
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
                tmp.add(node.val);
            }
            ans.add(new ArrayList<>(tmp));
        }
        return ans;
    }
}
