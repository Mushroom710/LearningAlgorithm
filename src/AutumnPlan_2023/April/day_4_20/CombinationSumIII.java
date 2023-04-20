package AutumnPlan_2023.April.day_4_20;

import java.util.ArrayList;
import java.util.List;

// @date 2023/4/20
// @time 21:38
// @author zhangzhi
// @description LeetCode 216. 组合总和 III
public class CombinationSumIII {

    private List<List<Integer>> ans;
    private List<Integer> path;
    private int k;

    private void dfs(int i, int n){
        int d = k - path.size();
        if(n < 0 || n > ((2 * i - d + 1) * d / 2)){
            return;
        }
        if(path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = i; j >= 1; j--){
            path.add(j);
            dfs(j - 1, n - j);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.ans = new ArrayList<>();
        this.path = new ArrayList<>();
        this.k = k;
        dfs(9, n);
        return ans;
    }
}
