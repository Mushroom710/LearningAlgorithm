package LeetCodeSpringRecruitment_2022.ten_week.day_four;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @DATE 2022/5/19
 * @TIME 19:29
 * @Created by zhangzhi
 * @description LeetCode 491 题 递增子序列
 */
public class IncreasingSubsequences {

    static List<List<Integer>> ans;
    static List<Integer> path;

    public static void backtracking(int[] nums,int startIndex){
        if (path.size() >= 2) {
            ans.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();// 使用set对本层元素进行去重
        for (int i = startIndex;i < nums.length;i++){
            // 记录这个元素在本层用过了，本层后面不能再用了
            if ((path.size() > 0 && path.get(path.size() - 1) > nums[i]) || !set.add(nums[i])){
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
    public static List<List<Integer>> findSubsequences(int[] nums){
        ans = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(nums,0);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,6,7,7};
        System.out.println(findSubsequences(nums));
    }
}
