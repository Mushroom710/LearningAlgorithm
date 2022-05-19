package LeetCodeSpringRecruitment_2022.ten_week.day_four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/5/19
 * @TIME 20:10
 * @Created by zhangzhi
 * @description LeetCode 47 题 全排列 II
 */
public class PermutationsII {

    static List<List<Integer>> ans;
    static List<Integer> path;
    public static void backtracking(int[] nums,boolean[] used){
        if (path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            // 去重 -- 与组合问题的去重逻辑一致 -- 集合首先得有序
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums){
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        ans = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(nums,used);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(permuteUnique(nums));
    }
}
