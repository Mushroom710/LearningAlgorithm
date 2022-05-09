package LeetCodeRankWeek._292_week;

/**
 * @DATE 2022/5/8
 * @TIME 10:53
 * @Created by zhangzhi
 * @description 292 场周赛 6057 题 统计值等于子树平均值的节点数
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

class point{
    int count;
    int sum;
    point(){
        count = 0;
        sum = 0;
    }
}

public class second {

    static int count;

    /**
     * @create zhangzhi
     * @date 2022/5/8
     * @time 11:45
     * @description 这里需要保存子树的节点个数和节点之和，所以需要一个类来保存
     * 用到后序遍历的原因是因为需要先统计出左子树和右子树的各个子树的节点数和节点和
     * 然后再计算
     */
    public static point recursion(TreeNode root){
        if (root == null)return new point();
        point ans = new point();
        ans.count++;
        ans.sum += root.val;
        point left = recursion(root.left);
        point right = recursion(root.right);
        ans.count = ans.count + left.count + right.count;
        ans.sum = ans.sum + left.sum + right.sum;
        if (ans.sum / ans.count == root.val){
            count++;
        }
        return ans;
    }

    public static int solution(TreeNode root){
        count = 0;
        recursion(root);
        return count;
    }

    public static void main(String[] args) {

    }
}
