package LeetCodeRankWeek_2023._344_week;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// @date 2023/5/7
// @time 10:25
// @author zhangzhi
// @description
public class first {
    public static int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
            pre[i] = set.size();
        }
        set = new HashSet<>();
        for(int i = n - 2; i >= 0; i--){
            set.add(nums[i + 1]);
            suf[i] = set.size();
        }
        int[] diff = new int[n];
        for(int i = 0; i < n; i++){
            diff[i] = pre[i] - suf[i];
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(distinctDifferenceArray(nums)));
    }
}
