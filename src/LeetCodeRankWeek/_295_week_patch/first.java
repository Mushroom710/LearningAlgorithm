package LeetCodeRankWeek._295_week_patch;

/**
 * @DATE 2022/6/3
 * @TIME 0:38
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static int rearrangeCharacters(String s, String target){
        int[] s_count = new int[26];
        int[] t_count = new int[26];
        for (int i = 0;i < s.length();i++){
            s_count[s.charAt(i) - 'a']++;
        }
        for (int i = 0;i < target.length();i++){
            t_count[target.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < target.length();i++){
            int idx = target.charAt(i) - 'a';
            min = Math.min(min,s_count[idx] / t_count[idx]);
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "ilovecodingonleetcode";
        String code = "code";
        System.out.println(rearrangeCharacters(s,code));
    }
}
