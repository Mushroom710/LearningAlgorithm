package AutumnPlan_2022.day_11_26;

// @date 2022/11/26
// @time 21:22
// @author zhangzhi
// @description LeetCode 383 题 赎金信

public class RansomNote {

    /**
     * 只包含小写字母，所以可以用数组作为hash表。注意统计字符串的先后顺序！
     * 当然，如果不是只包含小写字母，就只能用 HashMap 了。
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chs = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            chs[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            // 等于 0，说明这个字符在 magazine 中没有出现
            if(chs[ransomNote.charAt(i) - 'a'] == 0){
                return false;
            }else if(chs[ransomNote.charAt(i) - 'a']-- < 0){// 小于 0，说明 ransomNote 的这个字符个数大于 magazine 的字符个数
                return false;
            }
        }
        return true;
    }
}
