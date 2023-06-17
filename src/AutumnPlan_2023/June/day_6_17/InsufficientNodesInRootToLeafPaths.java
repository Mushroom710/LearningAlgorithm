package AutumnPlan_2023.June.day_6_17;

// @date 2023/6/17
// @time 10:14
// @author zhangzhi
// @description LeetCode 1080. 根到叶路径上的不足节点
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
public class InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        limit -= root.val;
        // 从上往下减，就是找 limit > 0 的路径删除。如果是从上往下加，就是找 路径和 < limit的删除
        if(root.left == root.right){
            // 比如 1 - (-99) = 100 ，说明这条路径从上往下加的和是小于 limit的
            // 反过来就是 limit > 0。
            return limit > 0 ? null : root;
        }
        if(root.left != null){
            root.left = sufficientSubset(root.left, limit);
        }
        if(root.right != null){
            root.right = sufficientSubset(root.right, limit);
        }
        // 如果 node 的儿子都被删除，说明经过 node 的所有儿子的路径和都小于 limit，这等价于经过
        // node 的所有路径和都小于 limit，所以 node 需要被删除。
        return root.left == root.right ? null : root;
    }
}
