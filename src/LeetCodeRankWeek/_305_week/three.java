package LeetCodeRankWeek._305_week;

// @DATE 2022/8/8
// @TIME 14:51
// @AUTHOR zhangzhi
// @DESCRIPTION

public class three {

    /**
     * DP五部曲:
     *      1.状态定义:f[i]代表考虑将[0,i]是否能被有效划分，有则为true，没有则为false
     *      2.状态转移:f[i]的转移有3种可能：
     *          2.1 由f[i-2]转移过来，且nums[i-1]==nums[i]
     *          2.2 由f[i-3]转移过来，且nums[i-2]==nums[i-1]==nums[i]
     *          2.3 由f[i-3]转移过来，且nums[i-1]==nums[i-2]+1;nums[i]==nums[i-1]+1
     *       其中一种能转移过来即可
     *      3.初始化:f[0]=false，f[1]=nums[0]==nums[1]，f[2]=nums[0]==nums[1]==nums[2]||递增
     *      4.遍历顺序:正序遍历[3,n-1]
     *      5.返回形式:返回f[n-1]
     * @param nums
     * @return
     */
    public static boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length];
//        dp[0] = true;
        dp[1] = nums[1] == nums[0];
        if (nums.length == 2) {
            return dp[1];
        }
        dp[2] = (nums[2] == nums[1] && nums[1] == nums[0]) || (nums[2] == nums[1] + 1 && nums[1] == nums[0] + 1);
        for (int i = 3;i < nums.length;i++) {
            boolean b1 = dp[i - 2] && nums[i - 1] == nums[i];
            boolean b2 = dp[i - 3] && (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]);
            boolean b3 = dp[i - 3] && (nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1);
            dp[i] = b1 || b2 || b3;
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,4,4,5};
        System.out.println(validPartition(nums));
    }
}
