package AutumnPlan_2023.March.day_3_27;

// @date 2023/3/27
// @time 22:00
// @author zhangzhi
// @description LeetCode 104. 二叉树的最大深度

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    /**
     * 层序遍历可以轻松找出树的高度和深度。
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }
}
