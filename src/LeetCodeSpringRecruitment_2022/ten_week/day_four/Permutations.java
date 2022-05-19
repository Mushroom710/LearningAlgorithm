package LeetCodeSpringRecruitment_2022.ten_week.day_four;

import java.util.ArrayList;
import java.util.List;

/**
 * @DATE 2022/5/19
 * @TIME 19:56
 * @Created by zhangzhi
 * @description LeetCode 46 题 全排列
 * 排列问题
 * 排列问题的不同：
 *  1.每层都是从 0 开始搜索而不是 startIndex
 *  2.需要 used 数组记录 path里都放了哪些元素了
 */
public class Permutations {

    static List<List<Integer>> ans;
    static List<Integer> path;
    public static void backtracking(int[] nums,boolean[] used) {
        if (path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length;i++){
            if (used[i])continue;// 元素使用过，直接跳过
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums,used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
    public static List<List<Integer>> permute(int[] nums){
        ans = new ArrayList<>();
        path = new ArrayList<>();
        // used数组，其实就是记录此时path里都有哪些元素使用了，一个排列里一个元素只能使用一次
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }
}
