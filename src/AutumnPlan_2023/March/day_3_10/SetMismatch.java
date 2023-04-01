package AutumnPlan_2023.March.day_3_10;

// @date 2023/3/10
// @time 21:44
// @author zhangzhi
// @description LeetCode 645. 错误的集合

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMismatch {

    /**
     * 排序加标记。对 nums[0] 和 nums[len - 1]的元素需要单独进行一次判断。
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int n = nums.length;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if(cur == prev){
                ans[0] = prev;
            }else if(cur - prev > 1){
                ans[1] = prev + 1;
            }
            prev = cur;
        }
        if (nums[n - 1] != n) {
            ans[1] = n;
        }
        return ans;
    }

    /**
     * 使用 哈希表 统计每个数字出现的次数，为 2 的就是重复数字，为 0 的就是丢失的数字。
     * @param nums
     * @return
     */
    public static int[] findErrorNumsHash(int[] nums) {
        Map<Integer,Integer> hash = new HashMap<>();
        int[] ans = new int[2];
        int n = nums.length;
        for(int num : nums){
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        for(int i = 1; i <= n; i++){
            int count = hash.getOrDefault(i, 0);
            if(count == 2){
                ans[0] = i;
            }else if(count == 0){
                ans[1] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,3,2,2,7,6,4,8,9};
//        System.out.println(Arrays.toString(findErrorNums(nums)));
        System.out.println(Arrays.toString(findErrorNumsHash(nums)));
    }
}
