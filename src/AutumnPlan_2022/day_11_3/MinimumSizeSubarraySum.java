package AutumnPlan_2022.day_11_3;

// @date 2022/11/3
// @time 21:07
// @author zhangzhi
// @description leetcode 209.长度最小的子数组

public class MinimumSizeSubarraySum {

    /**
     * 暴力解法过不了最后几个用例 --- 超时了
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;i++){
            int sum = 0;
            int j = i;
            while(true) {
                sum += nums[j];
                if(sum >= target){
                    len = Math.min(len,j - i + 1);
                    break;
                }else if(j == nums.length - 1){
                    break;
                }
                j++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    /**
     * i : 左边界 j : 右边界
     * sum 累加，当 sum >= target 时，这时需要调整左边界，直到 sum < target
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen_point(int target, int[] nums){
        int len = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0,j = 0;j < nums.length;j++){
            sum += nums[j];
            while (sum >= target){
                len = Math.min(len,j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7};
        System.out.println(minSubArrayLen_point(7,nums));
    }
}
