package AutumnPlan_2023.June.day_6_13;

import java.util.Arrays;

// @date 2023/6/13
// @time 10:40
// @author zhangzhi
// @description LeetCode 611. 有效三角形的个数
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = nums.length - 1; i > 1; i--){
            int x = nums[i];
            int left = 0;
            int right = i - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum > x){
                    ans += right - left;
                    right -= 1;
                }else{
                    left += 1;
                }
            }
        }
        return ans;
    }
}
