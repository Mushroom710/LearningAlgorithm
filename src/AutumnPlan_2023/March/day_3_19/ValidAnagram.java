package AutumnPlan_2023.March.day_3_19;

// @date 2023/3/19
// @time 21:01
// @author zhangzhi
// @description LeetCode 242. 有效的字母异位词
// 因为小写字母只有 26 个，所以可以定义一个 26 大小的数组来当做 hash 表

public class ValidAnagram {

    /**
     * 用一个 26 长度的数组统计 s 中字母出现的次数（chs[ch - 'a']++），
     * 然后再统计 t 中字母出现的次数(chs[ch - 'a']--)，
     * 然后再遍历 这个数组，看是否全部为 0。
     */
    public static boolean isAnagram(String s, String t) {
        int[] chs = new int[26];
        for(int i = 0; i < s.length(); i++){
            chs[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            chs[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            // chs 数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
            if(chs[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
