package LeetCodeSpringRecruitment_2022.second_week.day_seven;

/**
 * @DATE 2022/3/27
 * @TIME 21:52
 * @Created by zhangzhi
 * @description LeetCode 76 题 最小覆盖子串
 */
public class MinimumWindowSubstring {

    /**
     * @create zhangzhi
     * @date 2022/3/27
     * @time 22:01
     * @description 没做出来。
     */
    public static String solution(String s, String t) {
        if (s.equals(t)) {
            return s;
        }
        char[] chs_s = new char[26];
        char[] chs_t = new char[26];
        for (int i = 0; i < t.length(); i++) {
            chs_t[t.charAt(i) - 'a'] += 1;
        }

        for (int j = 0; j < s.length(); j++) {
            chs_s[s.charAt(j) - 'a'] += 1;
            for (int i = 0; i < t.length(); i++) {
                if (chs_t[t.charAt(i) - 'a'] != chs_s[t.charAt(i) - 'a']) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
