package SummerPlan_2022.day_6_9;

/**
 * @DATE 2022/6/9
 * @TIME 21:47
 * @Created by zhangzhi
 * @description LeetCode 968 题 监控二叉树
 * 从题目中示例，其实可以得到启发，我们发现题目示例中的摄像头都没有放在叶子节点上！
 * 所以把摄像头放在叶子节点的父节点位置，才能充分利用摄像头的覆盖面积。
 * 因为头结点放不放摄像头也就省下一个摄像头， 叶子节点放不放摄像头省下了的摄像头数量是指数阶别的。
 * 所以我们要从下往上看，局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，
 * 整体最优：全部摄像头数量所用最少！
 */

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

public class BinaryTreeCameras {
    static int ans;

    /**
     * @create zhangzhi
     * @date 2022/6/9
     * @time 21:57
     * @description
     * 如何隔两个节点放一个摄像头
     * 此时需要状态转移的公式，不要和动态的状态转移公式混到一起，
     * 本题状态转移没有择优的过程，就是单纯的状态转移！
     * 有三个数字来表示：
     *  0：该节点无覆盖
     *  1：本节点有摄像头
     *  2：本节点有覆盖
     * 为了让摄像头数量最少，我们要尽量让叶子节点的父节点安装摄像头，这样才能摄像头的数量最少。
     * 那么空节点不能是无覆盖的状态，这样叶子节点就要放摄像头了，
     * 空节点也不能是有摄像头的状态，这样叶子节点的父节点就没有必要放摄像头了，
     * 而是可以把摄像头放在叶子节点的爷爷节点上。
     * 所以空节点的状态只能是有覆盖，这样就可以在叶子节点的父节点放摄像头了
     */
    public static int traversal(TreeNode root){
        // 空节点，该节点有覆盖
        if (root == null){
            return 2;
        }
        // 获取左孩子的返回值，右孩子的返回值，即left 和 right， 以后推导中间节点的状态
        int left = traversal(root.left);
        int right = traversal(root.right);
        // 情况1
        // 左右节点都有覆盖
        if (left == 2 && right == 2){
            return 0;
        }
        // 情况2
        // left == 0 && right == 0 左右节点无覆盖
        // left == 1 && right == 0 左节点有摄像头，右节点无覆盖
        // left == 0 && right == 1 左节点有无覆盖，右节点摄像头
        // left == 0 && right == 2 左节点无覆盖，右节点覆盖
        // left == 2 && right == 0 左节点覆盖，右节点无覆盖
        if (left == 0 || right == 0){
            ans++;
            return 1;
        }
        // 情况3
        // left == 1 && right == 2 左节点有摄像头，右节点有覆盖
        // left == 2 && right == 1 左节点有覆盖，右节点有摄像头
        // left == 1 && right == 1 左右节点都有摄像头
        // 其他情况前段代码均已覆盖
        if (left == 1 || right == 1){
            return 2;
        }
        return -1;
    }

    public static int minCameraCover(TreeNode root) {
        ans = 0;
        // 情况4
        if (traversal(root) == 0){// root 无覆盖
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
