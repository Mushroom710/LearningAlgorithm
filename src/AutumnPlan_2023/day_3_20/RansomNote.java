package AutumnPlan_2023.day_3_20;

// @date 2023/3/20
// @time 21:34
// @author zhangzhi
// @description LeetCode 383. 赎金信

public class RansomNote {

    /**
     * 用一个字符数组来统计magazine中字符出现次数，然后再遍历ransomNote，从数组中把对应字符次数减一，如果小于0，说明不能构成。
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] mag = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            mag[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i <ransomNote.length(); i++){
            if(--mag[ransomNote.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
