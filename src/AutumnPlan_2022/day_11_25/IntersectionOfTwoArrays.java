package AutumnPlan_2022.day_11_25;

// @date 2022/11/25
// @time 21:21
// @author zhangzhi
// @description LeetCode 349 题 两个数组的交集

import java.util.*;

public class IntersectionOfTwoArrays {

    /**
     * 数据规模为[1,1000]，所以同样可以用一个大小为 1000 的数组来统计！
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        boolean[] nums1_1 = new boolean[1001];
        boolean[] nums2_2 = new boolean[1001];
        for(int num : nums1){
            nums1_1[num] = true;
        }
        for(int num : nums2){
            nums2_2[num] = true;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= 1000; i++){
            if(nums1_1[i] && nums2_2[i]){
                list.add(i);
            }
        }
        if(list.size() == 0){
            return new int[]{};
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * 简单优化一下。只用一个 hash 数组即可！把交集的结果放在set中，set自带去重。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection_plus(int[] nums1, int[] nums2){
        boolean[] hash = new boolean[1001];
        Set<Integer> set = new HashSet<>();
        for(int num : nums1){
            hash[num] = true;
        }
        for(int num : nums2){
            if(hash[num]){
                set.add(num);
            }
        }
        if(set.size() == 0){
            return new int[]{};
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for(int num : set){
            ans[i++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
