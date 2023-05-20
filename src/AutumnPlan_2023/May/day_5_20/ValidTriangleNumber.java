package AutumnPlan_2023.May.day_5_20;

import java.util.Arrays;

// @date 2023/5/20
// @time 9:43
// @author zhangzhi
// @description LeetCode 611. 有效三角形的个数
// 正难则反。正序遍历会漏掉答案，那么就倒序遍历
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = nums.length - 1; i > 1; i--){
            int l = 0;
            int r = i - 1;
            while(l < r){
                if(nums[l] + nums[r] > nums[i]){
                    ans += r - l;
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,3,4};
        System.out.println(new ValidTriangleNumber().triangleNumber(nums));
    }
}
