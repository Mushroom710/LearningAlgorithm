package LeetCodeSpringRecruitment_2022.eight_week.day_one;

import java.util.ArrayList;
import java.util.List;

/**
 * @DATE 2022/5/2
 * @TIME 21:54
 * @Created by zhangzhi
 * @description LeetCode 113 题 路径总和 II
 */
public class PathSumII {
    static List<List<Integer>> ans;
    static List<Integer> path;

    /**
     * @create zhangzhi
     * @date 2022/5/2
     * @time 22:30
     * @description path一直在改动，一但找到一个可行解，就要新分配一个list来保存
     */
    public static void recursion(TreeNode root,int targetSum){
        if (root == null)return;
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        recursion(root.left,targetSum);
        recursion(root.right,targetSum);
        path.remove(path.size() - 1);
    }

    public static List<List<Integer>> solution(TreeNode root,int targetSum){
        if (root == null)return new ArrayList<>();
        ans = new ArrayList<>();
        path = new ArrayList<>();
        recursion(root,targetSum);
        return ans;
    }

    public static void main(String[] args) {

    }
}
