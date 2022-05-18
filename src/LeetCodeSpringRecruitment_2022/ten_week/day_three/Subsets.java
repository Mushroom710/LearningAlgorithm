package LeetCodeSpringRecruitment_2022.ten_week.day_three;

import java.util.ArrayList;
import java.util.List;

/**
 * @DATE 2022/5/18
 * @TIME 19:32
 * @Created by zhangzhi
 * @description LeetCode 78 题 子集
 * 要清楚子集问题和组合问题、分割问题的的区别，
 * 子集是收集树形结构中树的所有节点的结果。
 * 而组合问题、分割问题是收集树形结构中叶子节点的结果
 */
public class Subsets {

    static List<List<Integer>> ans;
    static List<Integer> path;
    public static void backtracking(int[] nums,int startIndex){
        ans.add(new ArrayList<>(path));// 收集子集，要放在终止添加的上面，否则会漏掉自己
        for (int i = startIndex;i < nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums){
        ans = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(nums,0);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(subsets(nums));
    }
}
