package AutumnPlan_2022.day_12_2;

// @date 2022/12/2
// @time 21:52
// @author zhangzhi
// @description LeetCode 459. 重复的子字符串

public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        if(s.length() == 1){
            return false;
        }
        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++){
            counts[s.charAt(i) - 'a']++;
        }
        int count = counts[s.charAt(0) - 'a'];
        for(int i = 0; i < 26; i++){
            if(counts[i] != 0 && counts[i] != count){
                return false;
            }
        }
        int len = s.length() / count;
        char[] chs = new char[len];
        for(int i = 0; i < chs.length; i++){
            chs[i] = s.charAt(i);
        }
        for(int i = 0; i < len;){
            for(int j = 0; j < chs.length; j++){
                if(chs[j] != s.charAt(i + j)){
                    return false;
                }
            }
            i += s.length() / count;
            if(i > s.length() - 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ababba";
        System.out.println(repeatedSubstringPattern(s));
    }
}
