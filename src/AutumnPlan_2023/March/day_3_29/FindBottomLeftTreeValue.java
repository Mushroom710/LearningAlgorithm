package AutumnPlan_2023.March.day_3_29;

// @date 2023/3/29
// @time 22:15
// @author zhangzhi
// @description LeetCode 513. 找树左下角的值

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int mostDeepLeft = root.val;
        while(!queue.isEmpty()){
            int size = queue.size();
            mostDeepLeft = queue.peek().val;
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
        return mostDeepLeft;
    }
}
