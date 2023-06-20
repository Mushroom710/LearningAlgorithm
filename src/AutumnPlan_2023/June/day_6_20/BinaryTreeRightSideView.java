package AutumnPlan_2023.June.day_6_20;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// @date 2023/6/20
// @time 10:46
// @author zhangzhi
// @description LeetCode 199. 二叉树的右视图
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            TreeNode node = null;
            for(int i = 0; i < size; i++){
                node = deque.pollFirst();
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
            }
            ans.add(node.val);
        }
        return ans;
    }
}
