package AutumnPlan_2023.May.day_5_24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// @date 2023/5/24
// @time 11:07
// @author zhangzhi
// @description LeetCode 1090. 受标签影响的最大值
public class LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] idx = new Integer[n];
        for(int i = 0; i < n; i++){
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> values[b] - values[a]);
        int choose = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(choose == numWanted){
                break;
            }
            if(map.containsKey(labels[idx[i]]) && map.get(labels[idx[i]]) >= useLimit){
                continue;
            }
            choose++;
            ans += values[idx[i]];
            map.put(labels[idx[i]], map.getOrDefault(labels[idx[i]], 0) + 1);
        }
        return ans;
    }
}
