package AutumnPlan_2023.May.day_5_29;

// @date 2023/5/29
// @time 8:55
// @author zhangzhi
// @description LeetCode 1110. 删点成林

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DeleteNodesAndReturnForest {

    List<TreeNode> ans;

    Set<Integer> set;

    private TreeNode dfs(TreeNode root, boolean isRoot){
        if(root == null){
            return null;
        }
        boolean isDelete = set.contains(root.val);
        root.left = dfs(root.left, isDelete);
        root.right = dfs(root.right, isDelete);
        if(isDelete){
            return null;
        }else{
            if(isRoot){
                ans.add(root);
            }
            return root;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        this.ans = new ArrayList<>();
        this.set = new HashSet<>();
        for(int delete : to_delete){
            this.set.add(delete);
        }
        dfs(root, true);
        return ans;
    }
}
