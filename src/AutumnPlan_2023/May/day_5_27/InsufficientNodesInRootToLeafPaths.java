package AutumnPlan_2023.May.day_5_27;

// @date 2023/5/27
// @time 10:49
// @author zhangzhi
// @description LeetCode 1080. 根到叶路径上的不足节点

public class InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        limit -= root.val;
        if(root.left == root.right){
            return limit > 0 ? null : root;
        }
        if(root.left != null){
            root.left = sufficientSubset(root.left, limit);
        }
        if(root.right != null){
            root.right = sufficientSubset(root.right, limit);
        }
        return root.left == root.right ? null : root;
    }
}
