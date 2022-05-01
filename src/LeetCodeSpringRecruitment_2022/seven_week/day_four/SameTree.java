package LeetCodeSpringRecruitment_2022.seven_week.day_four;

/**
 * @DATE 2022/4/28
 * @TIME 21:26
 * @Created by zhangzhi
 * @description LeetCode 100 题 相同的树
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

public class SameTree {

    /**
     * @create zhangzhi
     * @date 2022/4/28
     * @time 21:32
     * @description 分析清楚几种不相同的情况即可
     * 1.左孩子为空，右孩子不为空 false
     * 2.左孩子不为空，右孩子为空 false
     * 3.左右孩子同时为空 true
     * 4.左右孩子不为空，比较 val true
     * 5.中间节点就是左右孩子的与
     */
    public static boolean recursion(TreeNode p,TreeNode q){
        if (p == null && q != null){// 1
            return false;
        }else if (p != null && q == null){ // 2
            return false;
        }else if (p == null && q == null){ // 3
            return true;
        }else if (p.val != q.val){ //4
            return false;
        }

        boolean left = recursion(p.left,q.left);// 左树左孩子，右树左孩子
        boolean right = recursion(p.right,q.right);// 左树右孩子，右树右孩子

        return left && right;//中间
    }

    public static boolean solution(TreeNode p,TreeNode q){
        return recursion(p,q);
    }

    public static void main(String[] args) {

    }
}
