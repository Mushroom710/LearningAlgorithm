package AutumnPlan_2023.May.day_5_12;

import java.util.HashMap;
import java.util.Map;

// @date 2023/5/12
// @time 22:07
// @author zhangzhi
// @description LeetCode 169. 多数元素
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int n = nums.length / 2;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > n){
                return entry.getKey();
            }
        }
        return 0;
    }
}
