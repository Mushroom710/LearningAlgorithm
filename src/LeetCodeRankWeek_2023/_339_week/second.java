package LeetCodeRankWeek_2023._339_week;

// @date 2023/4/2
// @time 11:01
// @author zhangzhi
// @description

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class second {

    public static List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        while(!map.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            Map<Integer, Integer> map2 = new HashMap<>(map);

            for(Map.Entry<Integer, Integer> entry : map2.entrySet()){
                tmp.add(entry.getKey());
                map.put(entry.getKey(), entry.getValue() - 1);
                if(map.get(entry.getKey()) == 0){
                    map.remove(entry.getKey());
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
