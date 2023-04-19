package AutumnPlan_2023.April.day_4_19;

import java.util.ArrayList;
import java.util.List;

// @date 2023/4/19
// @time 22:02
// @author zhangzhi
// @description LeetCode 78. 子集
public class Subsets {

    private List<List<Integer>> ans;
    private List<Integer> subset;
    private int[] nums;

    private void dfs(int i){
        ans.add(new ArrayList<>(subset));
        if(i == nums.length){
            return;
        }
        for(int j = i; j < nums.length; j++){
            subset.add(nums[j]);
            dfs(j + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        subset = new ArrayList<>();
        this.nums = nums;
        dfs(0);
        return ans;
    }
}
