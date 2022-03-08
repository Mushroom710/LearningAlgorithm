package LeetCode;

/**
 * @DATE 2022/3/8
 * @Created by zhangzhi
 * @description LeetCode 104/111题 二叉树的最小/最大深度
 * 1.使用递归解
 * 分别找左右子树的 max/min
 * 2.DFS
 * 遍历每一个结点时，记录下当前结点的深度
 * 找到叶子结点时，比较 max/min
 * 3.BFS
 * 一层一层的遍历
 * 遍历时，判断是否是叶子结点。更新 max/min
 */
public class maxAndminDepth {

    /**
     * @return a
     * @create zhangzhi
     * @date 2022/3/8
     * @time 19:53
     * @description 使用深度优先搜索的方式找二叉树的最小深度
     */
    public static int minDepthDFS(TreeNode root) {
        if (root == null) return 0;
        int left = minDepthDFS(root.left);// 向左子树递归找最小深度
        int right = minDepthDFS(root.right);//向右子树递归找最小深度
        // 巧妙的运用 left == 0 或 right == 0 这个特点
        return (left == 0 || right == 0) ? left + right + 1 : 1 + Math.min(left, right);
    }

    /**
     * @return a
     * @create zhangzhi
     * @date 2022/3/8
     * @time 19:54
     * @description
     */
    public static int maxDepthMax(TreeNode root) {
        return (root == null) ? 0 : 1 + Math.max(maxDepthMax(root.left), maxDepthMax(root.right));
    }

    public static void main(String[] args) {

    }
}
