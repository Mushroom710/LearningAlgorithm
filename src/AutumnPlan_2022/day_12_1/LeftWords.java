package AutumnPlan_2022.day_12_1;

// @date 2022/12/1
// @time 21:43
// @author zhangzhi
// @description LeetCode 剑指 Offer 58 - II. 左旋转字符串

public class LeftWords {

    /**
     * 先截取前 n 个字符，然后拼到 s 后，在截取 n 之后的字符！
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        String left = s.substring(0, n);
        return (s + left).substring(n);
    }

    private static void swap(char[] chs, int start, int end){
        while(start < end){
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * 先反转整个字符串，然后再分别反转前 s.len - n - 1的字符串，和 s.len - n 之后的字符串！
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords_2(String s, int n){
        char[] chs = s.toCharArray();
        swap(chs, 0, s.length() - 1);
        swap(chs, 0, s.length() - n - 1);
        swap(chs, s.length() - n, s.length() - 1);
        return new String(chs);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
//        System.out.println(reverseLeftWords(s, 2));
        System.out.println(reverseLeftWords_2(s, 2));
    }
}
