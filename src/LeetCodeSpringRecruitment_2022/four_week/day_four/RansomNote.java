package LeetCodeSpringRecruitment_2022.four_week.day_four;

/**
 * @DATE 2022/4/6
 * @TIME 20:52
 * @Created by zhangzhi
 * @description LeetCode 383 题 赎金信
 */
public class RansomNote {

    /**
     * @create zhangzhi
     * @date 2022/4/6
     * @time 21:07
     * @description
     * 暴力解法，枚举mag中的字符是否在ran中出现过，
     * 出现，就在ran中删去这个字符，然后一直枚举。如果最后ran.length()==0，
     * 说明ran可以由man构成
     */
    public static boolean solution_onw(String ransomNote,String magazine){
        for (int i = 0; i < magazine.length();i++){
            for (int j = 0; j < ransomNote.length();j++){
                if(ransomNote.charAt(j) == magazine.charAt(i)){
                    ransomNote = ransomNote.substring(0,j) + ransomNote.substring(j+1);
                    System.out.println(ransomNote);
                    break;
                }
            }
        }
        return ransomNote.length() == 0;
    }

    /**
     * @create zhangzhi
     * @date 2022/4/6
     * @time 21:11
     * @description 使用哈希表
     * 定义一个 26 大小的数组，用于统计字符出现次数
     * 先统计 magazine 中字符出现次数
     * 然后再统计 ransomNote 字符出现次数
     * 如果出现某个元素减到 <0 的情况，说明 ransomNote 不能由 magazine构成
     */
    public static boolean solution_two(String ransomNote,String magazine){
        int[] record = new int[26];
        for(int i = 0 ; i < magazine.length() ;i++){
            record[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++){
            record[ransomNote.charAt(i) - 'a']--;
            if (record[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String r = "aab";
        String m = "baa";
//        System.out.println(solution_onw(r,m));
        System.out.println(solution_two(r,m));
    }
}
