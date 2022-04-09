package LeetCodeSpringRecruitment_2022.four_week.day_six;

/**
 * @DATE 2022/4/9
 * @TIME 21:33
 * @Created by zhangzhi
 * @description LeetCode 剑指 offer 58 题 左旋字符串
 * 还记的那到反转字符串里的单词嘛？
 * 这两道题思路是一致的
 * 整体反转 + 局部反转
 */
public class LeftRotationString {

    /**
     * @create zhangzhi
     * @date 2022/4/9
     * @time 21:45
     * @description 反转指定区间的方法
     */
    private static void reverse(StringBuffer sb,int start ,int end){
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
     * @time 21:45
     * @description 整体反转 + 局部反转
     */
    public static String solution(String s,int k){
        StringBuffer sb = new StringBuffer(s);
        reverse(sb,0,k - 1);
        reverse(sb,k,sb.length() - 1);
        reverse(sb,0,sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(solution(s,3));
    }
}
