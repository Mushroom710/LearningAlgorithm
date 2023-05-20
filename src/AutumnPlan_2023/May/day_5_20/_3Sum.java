package AutumnPlan_2023.May.day_5_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @date 2023/5/20
// @time 8:39
// @author zhangzhi
// @description LeetCode 15. 三数之和
public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            int x = nums[i];
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = x + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> res = new ArrayList<>();
                    res.add(x);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    ans.add(res);
                    j += 1;
                    while(j < k && nums[j] == nums[j - 1]){
                        j += 1;
                    }
                    k -= 1;
                    while (j < k && nums[k] == nums[k + 1]){
                        k -= 1;
                    }
                }else if(sum < 0){
                    j += 1;
                }else {
                    k -= 1;
                }
            }
        }
        return ans;
    }
}
