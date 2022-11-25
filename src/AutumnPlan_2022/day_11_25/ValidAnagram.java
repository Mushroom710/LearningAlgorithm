package AutumnPlan_2022.day_11_25;

// @date 2022/11/25
// @time 21:11
// @author zhangzhi
// @description LeetCode 242 题 有效的字母异位词

public class ValidAnagram {

    /**
     * 因为只包含小写字母，所以可以用一个大小为26的数组来记录每个字母出现的次数。然后再比较每个字符出现的次数即可。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] s_count = new int[26];
        int[] t_count = new int[26];
        for(int i = 0; i < s.length(); i++){
            s_count[s.charAt(i) - 'a']++;
            t_count[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(s_count[i] != t_count[i]){
                return false;
            }
        }
        return true;
    }
}
