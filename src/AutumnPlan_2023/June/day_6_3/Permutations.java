package AutumnPlan_2023.June.day_6_3;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/3
// @time 11:17
// @author zhangzhi
// @description LeetCode 46. 全排列
public class Permutations {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] inPath;

    private void dfs(int i, int[] nums){
        if(i == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if(!inPath[j]){
                inPath[j] = true;
                path.add(nums[j]);
                dfs(i + 1, nums);
                path.remove(path.size() - 1);
                inPath[j] = false;
            }
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        this.inPath = new boolean[nums.length];
        dfs(0, nums);
        return ans;
    }
}
