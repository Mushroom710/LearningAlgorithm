package LeetCodeSpringRecruitment_2022.first_week;

/**
 * @DATE 2022/3/20
 * @TIME 19:58
 * @Created by zhangzhi
 * @description LeetCode 112 题 路径总和
 */
public class PathSum {

    /**
     * @create zhangzhi
     * @date 2022/3/20
     * @time 20:19
     * @description 只有左右子结点均为 null 的结点才是叶子结点
     */
    public static boolean solution(TreeNode root,int targetSum){
        if(root == null){
            return false;
        }
        return dfs(root,root,targetSum,0);
    }

    public static boolean dfs(TreeNode root,TreeNode pre,int targetSum,int sum){
        if(root == null && sum == targetSum && pre.left == null && pre.right == null){
            return true;
        }else if(root == null){
            return false;
        }

        sum += root.val;
        return dfs(root.left,root,targetSum,sum) || dfs(root.right,root,targetSum,sum);
    }

    public static void main(String[] args) {

    }
}
