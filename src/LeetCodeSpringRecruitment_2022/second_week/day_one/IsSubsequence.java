package LeetCodeSpringRecruitment_2022.second_week.day_one;

import java.util.Arrays;

/**
 * @DATE 2022/3/21
 * @TIME 20:48
 * @Created by zhangzhi
 * @description LeetCode 392 题 判断子序列
 * 本来雀食是一道很简单的题，想复杂了
 * 最简单的双指针法都忘的一干二净。。。
 */
public class IsSubsequence {

    /**
     * @create zhangzhi
     * @date 2022/3/21
     * @time 20:55
     * @description 知道的算法多了后，就不能很好的选择一种解法。
     */
    public static boolean solution(String s, String t){
        char[] chs = t.toCharArray();
        int i_s = 0;
        for(int i = 0; i < t.length(); i++){
            if(chs[i] != s.charAt(i_s)){
                chs[i] = ' ';
            }
        }
        System.out.println(Arrays.toString(chs));
        return s.equals(new String(chs));
    }

    /**
     * @create zhangzhi
     * @date 2022/3/21
     * @time 21:02
     * @description 双指针法
     */
    public static boolean solution_two(String s,String t){
        int m = s.length();
        int n = t.length();
        int i = 0;
        int j = 0;
        while (i < m && j < n){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == m;
    }

    public static void main(String[] args) {
        System.out.println(solution_two("abc","ahbgd"));
    }
}
