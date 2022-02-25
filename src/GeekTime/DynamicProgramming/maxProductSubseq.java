package GeekTime.DynamicProgramming;

import java.util.Arrays;

/**
 * @DATE 2022/2/25
 * @Created by zhangzhi
 * @description 乘积最大子序列问题。
 * 体会：别老想着斐波那契数列的递推公式，没那么通用
 */
public class maxProductSubseq {

    /**
     * @return a
     * @create zhangzhi
     * @date 2022/2/22
     * @time 20:01
     * @description 数组发生器,包含负数,数字出现区间为 [-max,max]
     */
    public static int[] CreateArr(){
        int max = 10;
        int size = (int)(Math.random()*max);
        System.out.println("数组大小为:"+size);
        int[] arr = new int[size];
        for(int i = 0;i<size;i++){
            double flag = Math.random();
            arr[i] = flag>0.5?(int)(Math.random()*max):(int)(Math.random()*(-max));
        }
        return arr;
    }

    /**
     * @return a
     * @create zhangzhi
     * @date 2022/2/25
     * @time 20:42
    * @description dp数组解释：因为 nums[i] 可能为正，也可能为负，
     * 所以需要存最大的正乘积和最小负乘积
     * dp[i][0] 存最大正乘积
     * dp[i][1] 存最小负乘积
     */
    public static int solution(int[] nums){
        int[][] dp = new int[nums.length][2];
        int max = nums[0];//记录最大乘积,初始化为 nums[0]
        dp[0][0]=nums[0];//初始化
        dp[0][1]=nums[0];
        for(int i = 1;i<nums.length;i++){
            dp[i][0] = Math.max(dp[i-1][0]*nums[i],Math.max(dp[i-1][1]*nums[i],nums[i]));
            dp[i][1] = Math.min(dp[i-1][0]*nums[i],Math.min(dp[i-1][1]*nums[i],nums[i]));
            //比较 max 和 dp[i][0] 哪个值最大
            if(max < dp[i][0]){
                max = dp[i][0];
            }
        }
        System.out.println(dp[nums.length-1][0]);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = CreateArr();
        System.out.println(Arrays.toString(nums));
        System.out.println(solution(nums));
    }
}
