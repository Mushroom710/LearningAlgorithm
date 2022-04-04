package LeetCodeSpringRecruitment_2022.four_week.day_one;

/**
 * @DATE 2022/4/4
 * @TIME 20:13
 * @Created by zhangzhi
 * @description LeetCode 有效的字母异位词 有效的字母异位词
 */
public class ValidAnagram {

    /**
     * @create zhangzhi
     * @date 2022/4/4
     * @time 20:24
     * @description 因为全是小写字母，所以可以用一个大小为 26 的数组
     * 先统计 s 中的字母个数，在 record 中 ++
     * 然后统计 t 中字母个数，在 record 中 --
     * 最后遍历 record ，如果有一个不为 0 说明不是有效的字母异位词
     */
    public static boolean solution(String s,String t){
        int[] record = new int[26];
        for(int i = 0; i < s.length(); i++){
            record[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            record[t.charAt(i) - 'a']--;
        }
        for(int num : record){
            if(num != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcd","bda"));
    }
}
