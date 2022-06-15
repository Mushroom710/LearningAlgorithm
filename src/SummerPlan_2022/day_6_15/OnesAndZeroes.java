package SummerPlan_2022.day_6_15;

/**
 * @DATE 2022/6/15
 * @TIME 20:04
 * @Created by zhangzhi
 * @description LeetCode 474 题 一和零
 * 我只能说：神奇，背包还可以分成两个维度
 * 本题中 strs 数组里的元素就是物品，每个物品都是一个！
 * 而 m 和 n相当于是一个背包，两个维度的背包。
 * 1.确定dp数组（dp table）以及下标的含义
 *  dp[i][j]：最多有 i个0和 j个1的 strs的最大子集的大小为 dp[i][j]。
 * 2.确定递推公式
 *  dp[i][j] 可以由前一个strs里的字符串推导出来，strs里的字符串有 zeroNum个 0，oneNum个1。
 *  dp[i][j] 就可以是 dp[i - zeroNum][j - oneNum] + 1。
 *  然后我们在遍历的过程中，取dp[i][j]的最大值。
 *  所以递推公式：dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
 */
public class OnesAndZeroes {

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs){// 遍历物品
            int _0_count = 0;
            int _1_count = 0;
            for (int i = 0;i < s.length();i++){
                if (s.charAt(i) == '0')_0_count++;
                else _1_count++;
            }
            for (int i = m;i >= _0_count;i--){// 遍历背包容量且从后向前遍历！
                for (int j = n;j >= _1_count;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i - _0_count][j - _1_count] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs,5,3));
    }
}
