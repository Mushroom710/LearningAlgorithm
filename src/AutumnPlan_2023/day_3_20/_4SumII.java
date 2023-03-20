package AutumnPlan_2023.day_3_20;

// @date 2023/3/20
// @time 21:20
// @author zhangzhi
// @description LeetCode 454. 四数相加 II

import java.util.HashMap;
import java.util.Map;

public class _4SumII {

    /**
     * 转化问题，a+b+c+d=0 --> 求 a+b 出现几次，存到一个map中，之后再应用两数之和的思想，就很容易了。
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int total = 0;
        for(int num1 : nums1){
            for(int num2 : nums2){
                map.put(-(num1 + num2), map.getOrDefault(-(num1 + num2), 0) + 1);
            }
        }
        for(int num3 : nums3){
            for(int num4 : nums4){
                if(map.containsKey(num3 + num4)){
                    total += map.get(num3 + num4);
                }
            }
        }
        return total;
    }
}
