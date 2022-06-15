package SummerPlan_2022.day_6_15;

/**
 * @DATE 2022/6/15
 * @TIME 20:44
 * @Created by zhangzhi
 * @description LeetCode 526 优美的排列
 * 没解出来。。。
 */
public class BeautifulArrangement {

    public static int countArrangement(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= n;j++){
                dp[j] = dp[j - 1] * 2 + 1;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(3));
    }
}
