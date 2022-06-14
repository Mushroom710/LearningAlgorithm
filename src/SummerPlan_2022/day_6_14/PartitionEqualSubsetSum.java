package SummerPlan_2022.day_6_14;

/**
 * @DATE 2022/6/14
 * @TIME 19:52
 * @Created by zhangzhi
 * @description LeetCode 416 题 分割等和子集
 * 01背包相对于本题，主要要理解，题目中物品是nums[i]，
 * 重量是nums[i]，价值也是nums[i]，背包体积是sum/2。
 */
public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 == 1)return false;
        int target = sum / 2;
        // dp[i]中的i表示背包内总和
        // 题目中说：每个数组中的元素不会超过 100，数组的大小不会超过 200
        // 总和不会大于20000，背包最大只需要其中一半，所以10001大小就可以了
        int[] dp = new int[10001];
        // 开始 01背包
        for (int i = 0;i < nums.length;i++){
            // 每一个元素一定是不可重复放入，所以从大到小遍历
            for (int j = target;j >= nums[i];j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        // 集合中的元素正好可以凑成总和target
        if (dp[target] == target)return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5};
        System.out.println(canPartition(nums));
    }
}
