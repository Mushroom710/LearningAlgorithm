package LeetCodeRankWeek_2023._341_week;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

// @date 2023/4/16
// @time 10:54
// @author zhangzhi
// @description
public class three {

    public static int addMinimum(String word) {
        int n = word.length();
        char[] chs = word.toCharArray();
        int[] dp = new int[n + 1];
        for(int i = 0; i < n; i++){
            dp[i + 1] = dp[i] + 2;
            if(i >= 1){
                if((chs[i] == chs[i - 1]) || (chs[i] != chs[i - 1])){
                    dp[i + 1] = Math.min(dp[i + 1], dp[i] + 4);
                }else {
                    dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
                }
            }
            if(i >= 2){
                if(chs[i] == 'c' && chs[i - 1] == 'b' && chs[i - 2] == 'a'){
                    dp[i + 1] = Math.min(dp[i + 1], dp[i - 2]);
                }else {
                    dp[i + 1] = Math.min(dp[i] + 2, dp[i + 1]);
                }
            }
        }
        return dp[n];
    }

    /**
     * 仔细分析题目意思，可以得出，word 是一个以 abc 为周期的周期字符串
     * 那么就可以通过求出 word 的最小周期，从而的出最少插入数
     */
    public int addMinimum2(String word) {
        int t = 1;
        for(int i = 1; i < word.length(); i++){
            // 计算 abc 的周期
            // aaaa -->  4个周期
            // aabc -->  2个周期
            // 周期怎么算：
            // 满足 a < b < c 的就是同一个周期，否则就是不同的周期
            if(word.charAt(i - 1) >= word.charAt(i)){
                t += 1;
            }
        }
        return 3 * t - word.length();
    }

    public static void main(String[] args) {
        String word = "abc";
        System.out.println(addMinimum(word));
    }
}
