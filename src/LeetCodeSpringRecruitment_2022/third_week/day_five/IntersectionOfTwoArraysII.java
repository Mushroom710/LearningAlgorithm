package LeetCodeSpringRecruitment_2022.third_week.day_five;

import java.util.*;

/**
 * @DATE 2022/4/1
 * @TIME 15:15
 * @Created by zhangzhi
 * @description LeetCode 350 题 两个数组的交集 II
 * 出 bug 了
 */
public class IntersectionOfTwoArraysII {

    public static int[] solution(int[] nums1,int[] nums2){
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[Math.min(len1,len2)];
        for(int num : nums1){
            if(map1.get(num) == null){
                map1.put(num,1);
            }else {
                map1.put(num,map1.get(num)+1);
            }
        }
        for(int num : nums2){
            if(map2.get(num) == null){
                map2.put(num,1);
            }else {
                map2.put(num,map2.get(num)+1);
            }
        }

        int idx = 0;
        if(len1 > len2){
            getMin(nums2, map1, map2, set, ans, idx);
        }else{
            getMin(nums1, map1, map2, set, ans, idx);
        }
        return Arrays.copyOfRange(ans,0,idx);
    }

    /**
     * @create zhangzhi
     * @date 2022/4/1
     * @time 15:34
     * @description 这里会出现 num1 有的元素，但是 nums2 没有。。。
     */
    private static void getMin(int[] nums2, Map<Integer, Integer> map1, Map<Integer, Integer> map2, Set<Integer> set, int[] ans, int idx) {
        for(int num : nums2){
            if(set.add(num)){
                int min = map1.get(num) > map2.get(num) ? map2.get(num):map1.get(num);
                Arrays.fill(ans,idx,idx+min,map1.get(num));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(solution(nums1,nums2)));
    }
}
