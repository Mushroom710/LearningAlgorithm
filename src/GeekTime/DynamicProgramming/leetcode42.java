package GeekTime.DynamicProgramming;

import java.util.Arrays;

/**
 * @DATE 2022/2/25
 * @Created by zhangzhi
 * @description 求连续子序列和最大问题
 */
public class leetcode42 {

    /**
     * @return a
     * @create zhangzhi
     * @date 2022/2/22
     * @time 20:01
     * @description 数组发生器,包含负数,数字出现区间为 [-max,max]
     */
    public static int[] CreateArr(){
        int max = 100;
        int size = (int)(Math.random()*max);
        System.out.println("数组大小为:"+size);
        int[] arr = new int[size];
        for(int i = 0;i<size;i++){
            double flag = Math.random();
            arr[i] = flag>0.5?(int)(Math.random()*max):(int)(Math.random()*(-max));
        }
        return arr;
    }

    public static int solution(int[] nums){
        if(nums.length<2){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = CreateArr();
        System.out.println(Arrays.toString(nums));
        System.out.println(solution(nums));
    }
}
