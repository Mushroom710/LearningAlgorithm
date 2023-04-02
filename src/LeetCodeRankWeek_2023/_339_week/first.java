package LeetCodeRankWeek_2023._339_week;

// @date 2023/4/2
// @time 10:30
// @author zhangzhi
// @description

public class first {

    public static int findTheLongestBalancedSubstring(String s) {
        int[] count = new int[2];
        int max = 0;
        char[] chs = new char[s.length() + 1];
        for(int i = 0; i < s.length(); i++){
            chs[i] = s.charAt(i);
        }
        chs[s.length()] = '0';
        for(int i = 0; i <= s.length(); i++){
            if(chs[i] == '0'){
                count[0]++;
            }else{
                count[1]++;
                if(chs[i + 1] == '0'){
                    max = Math.max(max, Math.min(count[0], count[1]) * 2);
                    count[0] = 0;
                    count[1] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "01000111";
        System.out.println(findTheLongestBalancedSubstring(s));
    }
}
