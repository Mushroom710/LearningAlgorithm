package AutumnPlan_2022.day_11_29;

// @date 2022/11/29
// @time 21:16
// @author zhangzhi
// @description LeetCode 541 题 反转字符串 II

import java.util.Arrays;

public class ReverseStringII {

    private static void swap(char[] chs, int left, int right){
        while(left <= right){
            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            left++;
            right--;
        }
    }

    /**
     * 滑动窗口
     * 固定一个大小 为 [0, 2K] 的窗口，每次都滑动 2K
     * 然后再对窗口前 k 个字符操作
     * 注意考虑好边界条件！
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int left = 0;
        int right = left + 2 * k;
        while(true){
            if(right > chs.length - 1){
                if(chs.length - left - 1 < k){
                    swap(chs, left, chs.length - 1);
                }else if(chs.length - left - 1 >= k){
                    swap(chs, left, left + k - 1);
                }
                return new String(chs);
            }
            swap(chs, left, left + k - 1);
            left += 2 * k;
            right += 2 * k;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(reverseStr(s, 2));
    }
}
