package AutumnPlan_2023.May.day_5_26;

import java.util.ArrayList;
import java.util.List;

// @date 2023/5/26
// @time 11:10
// @author zhangzhi
// @description LeetCode 129. 求根节点到叶节点数字之和
public class SumRootToLeafNumbers {
    int ans;
    List<Integer> path;

    private void dfs(TreeNode root){
        if(root.left == null && root.right == null){
            int num = 0;
            int size = path.size();
            for(int i = size; i > 0; i--){
                num += Math.pow(10, i - 1) * path.get(size - i);
            }
            ans += num;
        }
        if(root.left != null){
            path.add(root.left.val);
            dfs(root.left);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            path.add(root.right.val);
            dfs(root.right);
            path.remove(path.size() - 1);
        }
    }

    public int sumNumbers(TreeNode root) {
        this.ans = 0;
        this.path = new ArrayList<>();
        path.add(root.val);
        dfs(root);
        path.remove(path.size() - 1);
        return ans;
    }
}
