package AutumnPlan_2023.June.day_6_26;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/26
// @time 11:33
// @author zhangzhi
// @description LeetCode 216. 组合总和 III
public class CombinationSumIII {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void dfs(int i, int k, int t){
        int d = k - path.size();
        if(t < 0 || t > (2 * i - d + 1) * d / 2){
            return;
        }
        if(path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = i; j >= 1; j--){
            path.add(j);
            dfs(j - 1, k, t - j);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(9, k, n);
        return ans;
    }
}
