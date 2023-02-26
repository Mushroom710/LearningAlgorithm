package LeetCodeRankWeek_2023._334_week;

// @date 2023/2/26
// @time 10:10
// @author zhangzhi
// @description 6368. 找出字符串的可整除数组
// 对于可以被整除的数来说，num * 10 也不会改变能被整除的性质，所以可以通过前一个数来推断下一个数能否被整除！
// 从左到右计算。设当前数字为 x，每遇到一个数字 d，就把 x 更新为 (int)((10L * x + d) % m)

import java.util.Arrays;

public class second {

    public static int[] divisibilityArray(String word, int m) {
        int[] ans = new int[word.length()];
        for (int i = 0; i < ans.length; i++){
            String s = word.substring(0, i + 1);
            System.out.println(s);
            long num = Long.parseLong(s);
            if(num % m == 0){
                ans[i] = 1;
            }
        }
        return ans;
    }

    /**
     * 注意 int 会溢出
     * @param word
     * @param m
     * @return
     */
    public static int[] divisibilityArray2(String word, int m) {
        int[] dp = new int[word.length()];
        int x = 0;
        for(int i = 0; i < word.length(); i++){
            x = (int)((x * 10L + word.charAt(i) - '0') % m);
            if(x == 0){
                dp[i] = 1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String word = "1010";
        //System.out.println(Arrays.toString(divisibilityArray(word, 3)));
        System.out.println(Arrays.toString(divisibilityArray2(word,10)));
    }
}
