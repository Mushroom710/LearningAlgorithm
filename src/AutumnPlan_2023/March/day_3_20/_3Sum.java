package AutumnPlan_2023.March.day_3_20;

// @date 2023/3/20
// @time 21:43
// @author zhangzhi
// @description LeetCode 15. 三数之和 -- 梦破碎的地方

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int[] ids = new int[]{i,j,0};
                map.put(nums[i] + nums[j], ids);
            }
        }
        for(int k = 0; k < nums.length; k++){
            if(map.containsKey(-nums[k])){
                int[] ids = map.get(-nums[k]);
                if(k != ids[0] && k != ids[1] && ids[0] != ids[1]){
                    List<Integer> tmp = new ArrayList<>(3);
                    tmp.add(nums[ids[0]]);
                    tmp.add(nums[ids[1]]);
                    tmp.add(nums[k]);
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}
