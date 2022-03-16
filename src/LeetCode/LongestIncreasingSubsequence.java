package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @DATE 2022/3/16
 * @TIME 8:00
 * @Created by zhangzhi
 * @description LeetCode 300 题 最长递增子序列
 * 1.暴力递归
 *  a.每个元素有 选 or 不选
 *  b.剪枝.
 *      nums[i] < nums[j]
 * 2.DP
 *  当某个元素被选中，它前面的最长子序列是已经确定了（存在最优子结构）
 *  两部曲：
 *      a.状态定义：dp[i]: 从头->i 元素：最长子序列的长度
 *      ans = max(dp[0],dp[1]....dp[n-1])
 *      b.状态转移方程：
 *      dp[i] = max(dp[i],dp[j]+1)
 *          for i -> n-1
 *              dp[i] = max{dp[j]} + 1
 *              注：j: 0 -> i 且 a[j] < a[i]
 *
 *
 */
public class LongestIncreasingSubsequence {

    /**
     * @create zhangzhi
     * @date 2022/3/16
     * @time 8:20
     * @description 动态规划解法
     * 难点就是状态的定义和状态转移方程的推导
     */
    public static int solution(int[] nums){
        if(nums == null || nums.length<2){
            return 1;
        }
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1); // 最短的递增子序列就是 1
        int ans = 1;
        for(int i = 0; i < n; i++){
            for (int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/16
     * @time 8:47
     * @description 递归解法。没写出来
     */
    static int max = 1;
    static ArrayList<Integer> list = new ArrayList<>();
    public static int solution_two(int[] nums){
        if(nums == null || nums.length < 2){
            return 2;
        }
        for(int i = 0;i < nums.length - 2;i++){
            list.add(nums[i]);
            int len = recursion(1,nums,i);
            if(max < len){
                max = len;
            }
        }
        return max;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/16
     * @time 8:47
     * @description 递归写不明白。。。
     */
    public static int recursion(int len,int[] nums,int index){
        if(index > nums.length - 1){
            return list.size();
        }
        for(int i = index;i < nums.length - 1;i++){
            if(nums[i] < nums[i+1]) {
                list.add(nums[i]);
                len = recursion(len, nums, i + 1);
                list.remove(nums[i]);
            }
        }
        return len;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(solution(nums));
        System.out.println(solution_two(nums));
    }
}
