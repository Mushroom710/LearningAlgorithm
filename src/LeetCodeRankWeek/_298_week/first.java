package LeetCodeRankWeek._298_week;

/**
 * @DATE 2022/6/19
 * @TIME 10:20
 * @Created by zhangzhi
 * @description
 */
public class first {
    public static String greatestLetter(String s) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) >= 'a' && s.charAt(i) <='z'){
                lower[s.charAt(i) - 'a'] = true;
            }else {
                upper[s.charAt(i) - 'A'] = true;
            }
        }

        for (int i = lower.length - 1;i >=0;i--){
            if (lower[i] && upper[i]){
                char ch = (char) (i + 'A');
                return String.valueOf(ch);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "arRAzFif";
        System.out.println(greatestLetter(s));
    }
}
