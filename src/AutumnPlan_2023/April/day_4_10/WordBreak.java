package AutumnPlan_2023.April.day_4_10;

// @date 2023/4/10
// @time 22:07
// @author zhangzhi
// @description LeetCode 139. 单词拆分

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                // 如果[j,i]这个子串出现在 wordDict 里 && dp[j] 为 true
                // 那么 dp[i] 为 true
                if(set.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
