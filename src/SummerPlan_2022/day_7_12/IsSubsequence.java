package SummerPlan_2022.day_7_12;

import java.util.Arrays;

/**
 * @DATE 2022/7/12
 * @TIME 20:16
 * @Created by zhangzhi
 * @description LeetCode 392 题 判断子序列
 */
public class IsSubsequence {

    public static boolean doublePointer(String s,String t){
        int j = 0;
        for (int i = 0;i < s.length();i++){
            while (true){
                if (j != t.length() && s.charAt(i) == t.charAt(j)){
                    j++;
                    break;
                }else if (j == t.length()){
                    return false;
                }
                j++;
            }
        }
        return true;
    }

    // 1.确定dp数组（dp table）以及下标的含义
    //  dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]。
    //  注意这里是判断s是否为t的子序列。即t的长度是大于等于s的。
    // 2.确定递推公式
    //  在确定递推公式的时候，首先要考虑如下两种操作，整理如下：
    //  if (s[i - 1] == t[j - 1])
    //    t中找到了一个字符在s中也出现了
    //  if (s[i - 1] != t[j - 1])
    //    相当于t要删除元素，继续匹配
    //   if (s[i - 1] == t[j - 1])，那么dp[i][j] = dp[i - 1][j - 1] + 1;，
    //   因为找到了一个相同的字符，相同子序列长度自然要在dp[i-1][j-1]的基础上加1（如果不理解，
    //   在回看一下dp[i][j]的定义）
    //   if (s[i - 1] != t[j - 1])，此时相当于t要删除元素，t如果把当前元素t[j - 1]删除，
    //   那么dp[i][j] 的数值就是 看s[i - 1]与 t[j - 2]的比较结果了，
    //   即：dp[i][j] = dp[i][j - 1];
    public static boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int length = 0;
        for (int i = 1;i <= s.length();i++){
            for (int j = 1;j <= t.length();j++){
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
                if (length < dp[i][j]) length = dp[i][j];
            }
        }
        for (int[] nums : dp){
            System.out.println(Arrays.toString(nums));
        }
        return length == s.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(doublePointer(s,t));
        System.out.println(isSubsequence(s,t));
    }
}
