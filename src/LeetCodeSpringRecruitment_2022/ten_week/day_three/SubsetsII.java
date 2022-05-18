package LeetCodeSpringRecruitment_2022.ten_week.day_three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/5/18
 * @TIME 19:54
 * @Created by zhangzhi
 * @description LeetCode 90 题 子集 II
 */
public class SubsetsII {

    static List<List<Integer>> ans;
    static List<Integer> path;
    public static void backtracking(int[] nums,int startIndex,boolean[] used){
        ans.add(new ArrayList<>(path));
        for (int i = startIndex;i < nums.length;i++){
            // used[i - 1] == true，说明同一树枝 nums[i - 1] 使用过
            // used[i - 1] == false，说明同一树层 nums[i - 1] 使用过
            // 而我们要对同一树层使用过的元素进行跳过
            // i > 0 是因为 0 号元素最初肯定没有使用过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums,i + 1,used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        ans = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(nums,0,used);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
