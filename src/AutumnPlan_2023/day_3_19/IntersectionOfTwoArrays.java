package AutumnPlan_2023.day_3_19;

// @date 2023/3/19
// @time 21:11
// @author zhangzhi
// @description LeetCode 349. 两个数组的交集

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays {

    /**
     * 数据量有限制，所以直接定义一个 1001 大小的数组，用来标记数字是否出现。
     * 先统计 nums1 中出现的数字
     * 然后遍历 nums2 ，看对应的数字的 boo[num] 是否为 true
     * true 就收集，然后置为 false
     * 因为求的是交集，所以只需要收集一次即可
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        boolean[] boo = new boolean[1001];
        for(int num : nums1) {
            boo[num] = true;
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2) {
            if(boo[num]){
                list.add(num);
                boo[num] = false;
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
