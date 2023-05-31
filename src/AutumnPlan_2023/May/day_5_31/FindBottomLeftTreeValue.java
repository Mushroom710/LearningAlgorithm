package AutumnPlan_2023.May.day_5_31;

import java.util.ArrayDeque;
import java.util.Deque;

// @date 2023/5/31
// @time 9:34
// @author zhangzhi
// @description LeetCode 513. 找树左下角的值
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode ans = root;
        deque.addLast(root);
        while(!deque.isEmpty()){
            ans = deque.pollFirst();
            if(ans.right != null){
                deque.addLast(ans.right);
            }
            if(ans.left != null){
                deque.addLast(ans.left);
            }
        }
        return ans.val;
    }
}
