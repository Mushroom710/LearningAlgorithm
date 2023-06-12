package AutumnPlan_2023.June.day_6_12;

// @date 2023/6/12
// @time 10:09
// @author zhangzhi
// @description LeetCode 392. 判断子序列
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int sl = s.length();
        int tl = t.length();
        while(i < sl && j < tl){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == sl;
    }
}
