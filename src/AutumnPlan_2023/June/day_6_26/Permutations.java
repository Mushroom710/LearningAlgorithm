package AutumnPlan_2023.June.day_6_26;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/26
// @time 11:34
// @author zhangzhi
// @description LeetCode 46. 全排列
public class Permutations {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] onPath = new boolean[6];

    private void dfs(int[] nums){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if(!onPath[j]){
                onPath[j] = true;
                path.add(nums[j]);
                dfs(nums);
                path.remove(path.size() - 1);
                onPath[j] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return ans;
    }
}
