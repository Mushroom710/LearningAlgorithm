package AutumnPlan_2023.June.day_6_20;

import java.util.ArrayDeque;
import java.util.Deque;

// @date 2023/6/20
// @time 10:46
// @author zhangzhi
// @description LeetCode 513. 找树左下角的值
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode ans = root;
        deque.add(root);
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
