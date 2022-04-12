package LeetCodeSpringRecruitment_2022.five_week.day_two;

/**
 * @DATE 2022/4/12
 * @TIME 23:03
 * @Created by zhangzhi
 * @description LeetCode 459 题 重复的子字符串
 */
public class RepeatedSubstringPattern {

    private static void getNext(int[] next,String s){
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length();i++){
            while (j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0){
            return false;
        }
        int len = s.length();
        int[] next = new int[len];
        getNext(next,s);

        // 注意理解这个
        // 数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，
        // 也就是一个周期的长度，
        // 如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
        return next[len - 1] != 0 && len % (len - next[len - 1]) == 0;
    }

    public static void main(String[] args) {
        String s = "ababababab";
        System.out.println(repeatedSubstringPattern(s));
    }
}
