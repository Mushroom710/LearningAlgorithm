package AutumnPlan_2023.April.day_4_20;

import java.util.ArrayList;
import java.util.List;

// @date 2023/4/20
// @time 21:37
// @author zhangzhi
// @description LeetCode 77. 组合
public class Combinations {

    private List<List<Integer>> ans;
    private List<Integer> path;

    private void dfs(int i, int k){

        if(i + path.size() < k){
            return;
        }

        if(path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }

        dfs(i - 1, k);

        path.add(i);
        dfs(i - 1, k);
        path.remove(path.size() - 1);

        // for(int j = i; j >= 1; j--){
        //     path.add(j);
        //     dfs(j - 1, k);
        //     path.remove(path.size() - 1);
        // }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.ans = new ArrayList<>();
        this.path = new ArrayList<>();
        dfs(n, k);
        return ans;
    }
}
