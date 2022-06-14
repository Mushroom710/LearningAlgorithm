package SummerPlan_2022.day_6_14;

/**
 * @DATE 2022/6/14
 * @TIME 20:11
 * @Created by zhangzhi
 * @description LeetCode 1049 题 最后一块石头的重量 II
 * (没想到这个)
 * 思路：本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了。
 * 剩下的就是 01 背包的基础操作了
 * 在计算 target的时候，target = sum / 2 因为是向下取整，
 * 所以 sum - dp[target]（其中的一堆） 一定是大于等于 dp[target]（另一堆） 的。
 * 那么相撞之后剩下的最小石头重量就是 (sum - dp[target]) - dp[target]
 */
public class LastStoneWeightII {

    public static int lastStoneWeightII(int[] stones) {
        int[] dp = new int[15001];
        int sum = 0;
        for (int stone : stones){
            sum += stone;
        }
        int target = sum / 2;
        for (int i = 0;i < stones.length;i++){
            for (int j = target;j >= stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
            }
        }
        return (sum - dp[target]) - dp[target];
    }

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        System.out.println(lastStoneWeightII(stones));
    }
}
