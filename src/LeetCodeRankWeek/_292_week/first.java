package LeetCodeRankWeek._292_week;

/**
 * @DATE 2022/5/8
 * @TIME 10:24
 * @Created by zhangzhi
 * @description 6056 题 字符串中最大的 3 位相同数字
 */
public class first {

    public static String solution(String num){
        int max = -1;
        for (int i = 0;i < num.length() - 2;i++){
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i+1) == num.charAt(i + 2)){
                max = Math.max(max,Integer.parseInt(String.valueOf(num.charAt(i))));
            }
        }
        if (max == -1){
            return "";
        }
        StringBuffer ans = new StringBuffer();
        for (int i = 0;i < 3;i++){
            ans.append(max);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("42352338"));
    }
}
