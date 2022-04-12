package LeetCodeSpringRecruitment_2022.five_week.day_two;

/**
 * @DATE 2022/4/12
 * @TIME 23:00
 * @Created by zhangzhi
 * @description LeetCode 28 题 实现 strStr()
 */
public class ImplementstrStr {

    private static void getNext(int[] next,String needle){
        int j = 0;
        next[0] = 0 ;
        for(int i = 1; i < needle.length(); i++){
            while(j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next,needle);

        int j = next[0];
        for (int i = 0; i < haystack.length(); i++){
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if (j == needle.length()){
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String haystack = "abababa";
        String needle = "abab";
        System.out.println(strStr(haystack,needle));

    }
}
