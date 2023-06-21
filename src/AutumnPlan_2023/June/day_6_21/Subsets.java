package AutumnPlan_2023.June.day_6_21;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/21
// @time 10:52
// @author zhangzhi
// @description LeetCode 78. 子集
public class Subsets {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    private void dfs(int i){
        ans.add(new ArrayList<>(path));
        if(i == nums.length){
            return;
        }

        for(int j = i; j < nums.length; j++){
            path.add(nums[j]);
            dfs(j + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }
}
