package AutumnPlan_2023.May.day_5_30;

import java.util.ArrayList;
import java.util.List;

// @date 2023/5/30
// @time 9:59
// @author zhangzhi
// @description LeetCode 501. 二叉搜索树中的众数

public class FindModeInBinarySearchTree {
    List<Integer> ans = new ArrayList<>();

    int cnt = 0;
    int max = 0;
    TreeNode pre = null;

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(pre == null){
            cnt = 1;
        }else if(pre.val == root.val){
            cnt += 1;
        }else{
            cnt = 1;
        }
        pre = root;

        if(cnt > max){
            max = cnt;
            ans = new ArrayList<>();
            ans.add(pre.val);
        }else if(cnt == max){
            ans.add(pre.val);
        }

        dfs(root.right);
    }

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] nums = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            nums[i] = ans.get(i);
        }
        return nums;
    }
}
