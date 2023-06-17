package AutumnPlan_2023.June.day_6_17;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/17
// @time 10:16
// @author zhangzhi
// @description LeetCode 199. 二叉树的右视图
public class BinaryTreeRightSideView {
    List<Integer> ans = new ArrayList<>();

    private void dfs(TreeNode root, int dep){
        if(root == null){
            return;
        }
        if(dep == ans.size()){
            ans.add(root.val);
        }
        dfs(root.right, dep + 1);
        dfs(root.left, dep + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
}
