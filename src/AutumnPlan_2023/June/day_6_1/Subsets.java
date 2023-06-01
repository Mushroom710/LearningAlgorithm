package AutumnPlan_2023.June.day_6_1;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/1
// @time 10:10
// @author zhangzhi
// @description LeetCode 78. 子集

public class Subsets {

    List<List<Integer>> ans;
    List<Integer> path;
    int[] nums;

    private void dfs(int i){
        ans.add(new ArrayList<>(path));

        for(int j = i; j < nums.length; j++){
            path.add(nums[j]);
            dfs(j + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.ans = new ArrayList<>();
        this.path = new ArrayList<>();
        dfs(0);

        return ans;
    }
}
