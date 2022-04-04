package LeetCodeSpringRecruitment_2022.four_week.day_one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @DATE 2022/4/4
 * @TIME 20:30
 * @Created by zhangzhi
 * @description LeetCode 349 题 两个数组的交集
 * 这道题在 third_week day_five 中写过一次，当时用的是二分查找加 set
 *
 * 这次只使用 set
 *
 * 因为是求两个数组的交集，所以先遍历一个数组，把遍历的结果放在一个 set 中，
 * 然后再遍历另外一个数组，看里面的元素在不在 set 中出现，
 * 如果出现，就加入一个 ansSet 中
 * 最后把 ansSet 转为数组返回即可
 * 题目已经说明：不考虑输出结果的顺序
 */

public class IntersectionOfTwoArrays {

    public static int[] solution(int[] nums1,int[] nums2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> ansSet = new HashSet<>();
        for(int nums : nums1){
            set.add(nums);
        }

        for(int nums : nums2){
            if(set.contains(nums)){
                ansSet.add(nums);
            }
        }
        int[] ans = new int[ansSet.size()];
        int idx = 0;
        for(int nums : ansSet){
            ans[idx++] = nums;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(solution(nums1, nums2)));
    }
}
