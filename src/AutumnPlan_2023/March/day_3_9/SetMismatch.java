package AutumnPlan_2023.March.day_3_9;

// @date 2023/3/9
// @time 22:20
// @author zhangzhi
// @description LeetCode 645. 错误的集合

import java.util.HashMap;
import java.util.Map;

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                errorNums[0] = i;
            } else if (count == 0) {
                errorNums[1] = i;
            }
        }
        return errorNums;
    }
}
