package AutumnPlan_2023.June.day_6_2;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/2
// @time 10:24
// @author zhangzhi
// @description LeetCode 77. 组合
public class Combinations {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void dfs(int i, int k){
        int d = k - path.size();
        if(path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = i; j > d - 1; j--){
            path.add(j);
            dfs(j - 1, k);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k);
        return ans;
    }
}
