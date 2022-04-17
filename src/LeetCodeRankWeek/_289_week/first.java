package LeetCodeRankWeek._289_week;

/**
 * @DATE 2022/4/17
 * @TIME 15:02
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static String solution(String s,int k){
        if (s.length() <= k){
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (s.length() > k) {
            for (; i < s.length(); i += k) {
                int sum = 0;
                for (int j = i;i + k <= s.length()&&j < i + k;j++){
                    sum += Integer.parseInt(String.valueOf(s.charAt(j)));
                }
                if (i + k > s.length()){
                    break;
                }
                ans.append(sum);
            }
            if (s.length() - i < k && s.length() - i != 0){
                int sum = 0;
                for (int j = i; j < s.length();j++){
                    sum += Integer.parseInt(String.valueOf(s.charAt(j)));
                }
                ans.append(sum);
            }
            i = 0;
            s = ans.toString();
            ans = new StringBuilder();
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "1234";
        System.out.println(solution(s,2));
    }
}
