package AutumnPlan_2022.day_11_29;

// @date 2022/11/29
// @time 21:03
// @author zhangzhi
// @description LeetCode 344 题 反转字符串

public class ReverseString {

    /**
     * 双指针法
     * @param s
     */
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left <= right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
