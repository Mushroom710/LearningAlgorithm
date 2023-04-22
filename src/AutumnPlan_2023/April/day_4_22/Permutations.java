package AutumnPlan_2023.April.day_4_22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @date 2023/4/22
// @time 22:19
// @author zhangzhi
// @description LeetCode 46. 全排列
public class Permutations {
    private List<List<Integer>> ans;
    private List<Integer> path;
    private int n;

    private void dfs(int i, Set<Integer> set){
        if(i == n){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int num : set){
            path.add(num);
            Set<Integer> set2 = new HashSet<>(set);
            set2.remove(num);
            dfs(i + 1, set2);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        this.ans = new ArrayList<>();
        this.path = new ArrayList<>();
        this.n = nums.length;

        dfs(0, set);

        return this.ans;
    }
}
