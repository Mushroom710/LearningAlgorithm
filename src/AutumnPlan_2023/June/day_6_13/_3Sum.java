package AutumnPlan_2023.June.day_6_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @date 2023/6/13
// @time 9:35
// @author zhangzhi
// @description LeetCode 15. 三数之和
public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            int x = nums[i];
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = x + nums[left] + nums[right];
                if(sum > 0){
                    right -= 1;
                }else if(sum < 0){
                    left += 1;
                }else{
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left += 1;
                    while(left < right && nums[left] == nums[left - 1]){
                        left += 1;
                    }
                    right -= 1;
                    while(left < right && nums[right] == nums[right + 1]){
                        right -= 1;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(new _3Sum().threeSum(nums));
    }
}
