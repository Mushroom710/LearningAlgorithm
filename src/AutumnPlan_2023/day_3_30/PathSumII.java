package AutumnPlan_2023.day_3_30;

// @date 2023/3/30
// @time 22:07
// @author zhangzhi
// @description LeetCode 113. 路径总和 II

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    List<List<Integer>> ans;
    List<Integer> list;

    private void getPath(TreeNode root, int sum){
        if(root.left == null && root.right == null && sum == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        if(root.left != null){
            list.add(root.left.val);
            getPath(root.left, sum - root.left.val);
            list.remove(list.size() - 1);
        }
        if(root.right != null){
            list.add(root.right.val);
            getPath(root.right, sum - root.right.val);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        list = new ArrayList<>();
        list.add(root.val);
        getPath(root, targetSum - root.val);
        return ans;
    }
}
