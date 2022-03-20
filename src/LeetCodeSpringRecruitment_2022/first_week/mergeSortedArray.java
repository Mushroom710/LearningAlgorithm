package LeetCodeSpringRecruitment_2022.first_week;

import java.util.Arrays;

/**
 * @DATE 2022/3/20
 * @TIME 17:39
 * @Created by zhangzhi
 * @description LeetCode 88 题 合并两个有序数组
 */
public class mergeSortedArray {


    /**
     * @create zhangzhi
     * @date 2022/3/20
     * @time 17:40
     * @description nums1 的初始长度为 m+n
     */
    public static void solution(int[] nums1, int m, int[] nums2, int n){
        if (n >= 0) System.arraycopy(nums2, 0, nums1, m , n);

        Arrays.sort(nums1);
    }

    public static void main(String[] args) {

    }
}
