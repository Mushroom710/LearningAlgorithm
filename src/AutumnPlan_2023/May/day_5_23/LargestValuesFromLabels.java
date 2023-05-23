package AutumnPlan_2023.May.day_5_23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @date 2023/5/23
// @time 10:13
// @author zhangzhi
// @description
public class LargestValuesFromLabels {

    private Map<Integer, Integer> map;

    private List<Integer> path;

    private int ans = -1;

    private int[] labels;

    private int[] values;

    private int numWanted;

    private int useLimit;

    private void dfs(int i){
        if(map.size() > 0 && path.size() <= numWanted){
            int sum = 0;
            for(int num : path){
                sum += num;
            }
            ans = Math.max(ans, sum);
        }

        for(int k = i; k < labels.length; k++){
            if(path.size() < numWanted && map.getOrDefault(labels[k], 0) < useLimit){
                map.put(labels[k], map.getOrDefault(labels[k], 0) + 1);
                path.add(values[k]);
                dfs(k + 1);
                map.put(labels[k], map.get(labels[k]) - 1);
                path.remove(path.size() - 1);
            }
        }
    }
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        this.map = new HashMap<>();
        this.path = new ArrayList<>();
        this.values = values;
        this.labels = labels;
        this.numWanted = numWanted;
        this.useLimit = useLimit;
        dfs(0);
        return this.ans;
    }

    public static void main(String[] args) {
        int[] values = new int[]{5,4,3,2,1};
        int[] labels = new int[]{1,3,3,3,2};
        System.out.println(new LargestValuesFromLabels().largestValsFromLabels(values, labels, 3, 2));
    }
}
