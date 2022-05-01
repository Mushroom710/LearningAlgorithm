package LeetCodeSpringRecruitment_2022.seven_week.day_four;

/**
 * @DATE 2022/4/28
 * @TIME 22:09
 * @Created by zhangzhi
 * @description LeetCode 513 题 找树左下角的值
 */
public class FindBottomLeftTreeValue {

    static int deep = -1;
    static int left = 0;

    public static void recursion(TreeNode root,int maxDeep){
        if (root == null)return;
        if (root.left == null && root.right == null){
            if (maxDeep > deep){
                deep = maxDeep;
                left = root.val;
            }
        }
        if (root.left != null)recursion(root.left,maxDeep + 1);
        if (root.right != null)recursion(root.right,maxDeep + 1);
    }

    public static int solution(TreeNode root){
        left = root.val;
        recursion(root,0);
        return left;
    }

    public static void main(String[] args) {

    }
}
