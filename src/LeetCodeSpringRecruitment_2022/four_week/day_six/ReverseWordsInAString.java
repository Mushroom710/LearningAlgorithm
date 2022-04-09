package LeetCodeSpringRecruitment_2022.four_week.day_six;

import java.util.Arrays;

/**
 * @DATE 2022/4/9
 * @TIME 20:22
 * @Created by zhangzhi
 * @description LeetCode 151 题 颠倒字符串中的单词
 */
public class ReverseWordsInAString {
    /**
     * @create zhangzhi
     * @date 2022/4/9
     * @time 20:42
     * @description 直接使用库函数，但是这不是刷题的目的！
     */
    public static String solution(String s){
        // 去除收尾空格
        s = s.trim();
        // 按照空格分割字符串
        String[] ss = s.split(" ");

        StringBuilder ans = new StringBuilder();
        for(int i = ss.length - 1; i >= 1; i--){
            if(!"".equals(ss[i])){
                ans.append(ss[i]).append(" ");
            }
        }
        if(!"".equals(ss[0])){
            ans.append(ss[0]);
        }
        return ans.toString();
    }

    /**
     * @create zhangzhi
     * @date 2022/4/9
     * @time 21:29
     * @description 不使用库函数
     */
    public static String solution_two(String s){
        StringBuffer sb = removeSpace(s);
        reverse(sb,0,sb.length() - 1);
        reverseEach(sb);
        return sb.toString();
    }

    /**
     * @create zhangzhi
     * @date 2022/4/9
     * @time 21:29
     * @description 去除多余空格
     */
    private static StringBuffer removeSpace(String s){
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ')start++;
        while (s.charAt(end) == ' ')end--;
        StringBuffer sb = new StringBuffer();
        while (start <= end){
            char c = s.charAt(start);
            // 这个判断语句简直绝妙，要多多学习学习这种写法
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    /**
     * @create zhangzhi
     * @date 2022/4/9
     * @time 21:30
     * @description 反转指定区间的字符串
     */
    private static void reverse(StringBuffer sb,int start,int end){
        while (start < end){
            char tmp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,tmp);
            start++;
            end--;
        }
    }

    /**
     * @create zhangzhi
     * @date 2022/4/9
     * @time 21:30
     * @description 反转每一个单词
     *
     */
    private static void reverseEach(StringBuffer sb){
        int start = 0;
        int end = 1;
        int len = sb.length();
        // 这里要注意不要越界
        while (end < len){
            while (end < len && sb.charAt(end) != ' ')end++;
            reverse(sb,start,end - 1);
            start = end + 1;
            end = end + 1;
        }
    }

    public static void main(String[] args) {
        String s = "       hello     world";
//        System.out.println(solution(s));
        System.out.println(solution_two(s));
    }
}
