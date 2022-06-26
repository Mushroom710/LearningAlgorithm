package SummerPlan_2022.day_6_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/6/26
 * @TIME 22:12
 * @Created by zhangzhi
 * @description LeetCode 139 题 单词拆分
 * 单词就是物品，字符串s就是背包，单词能否组成字符串s，就是问物品能不能把背包装满。
 * 拆分时可以重复使用字典中的单词，说明就是一个完全背包！
 *
 * dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
 *
 * 如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是 true。（j < i ）。
 * 所以递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true。
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1;i <= s.length();i++){
            for (int j = 0;j < i;j++){
                if (wordDict.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] ss = new String[]{"leet", "code"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(ss));
        System.out.println(wordBreak(s,list));
    }
}
