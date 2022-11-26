package AutumnPlan_2022.day_11_26;

// @date 2022/11/26
// @time 21:04
// @author zhangzhi
// @description LeetCode 454 题 四数相加 II

import java.util.HashMap;
import java.util.Map;

public class _4SumII {

    /**
     * 暴力法经典超时
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++){
                    for(int l = 0; l < n; l++){
                        if(nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 学会灵活运用Map。当然，更重要的是解题的思路和转化问题！
     * 题目并没有说不可以元素重复使用，所以，先用map统计v1+v2出现的次数
     * 然后再在map中查找 -(v3+v4)是否出现。
     * v1+v2 = -(v3+v4)
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCountHash(int[] nums1, int[] nums2,int[] nums3,int[] nums4){
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int num1 : nums1){
            for(int num2 : nums2){
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        for(int num3 : nums3){
            for(int num4 : nums4){
                if(map.containsKey(-(num3 + num4))){
                    count += map.get(-(num3 + num4));
                }
            }
        }
        return count;
    }
}
