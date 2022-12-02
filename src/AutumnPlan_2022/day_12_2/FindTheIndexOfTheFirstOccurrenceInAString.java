package AutumnPlan_2022.day_12_2;

// @date 2022/12/2
// @time 21:38
// @author zhangzhi
// @description LeetCode 28. 找出字符串中第一个匹配项的下标
// next 数组有统一减 1 和不减 1，这两种只是对于 kmp 的具体实现不同，思想还是一致的！
// kmp 的代码实现不是很熟练，保持练习！

public class FindTheIndexOfTheFirstOccurrenceInAString {

    private static int[] getNext(String needle){
        int j = -1;
        int[] next = new int[needle.length()];
        next[0] = j;
        for(int i = 1; i < needle.length(); i++){
            while(j >= 0 && needle.charAt(i) != needle.charAt(j + 1)){
                j = next[j];
            }
            if(needle.charAt(i) == needle.charAt(j + 1)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * 回顾 KMP 算法！对于 next 数组代码实现不是特别熟练！
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int[] next = getNext(needle);
        int j = -1;
        for(int i = 0; i < haystack.length(); i++){
            while(j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)){
                j = next[j];
            }
            if(haystack.charAt(i) == needle.charAt(j + 1)){
                j++;
            }
            if(j == needle.length() - 1){
                return i - j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "code";
        System.out.println(strStr(haystack,needle));
    }
}
