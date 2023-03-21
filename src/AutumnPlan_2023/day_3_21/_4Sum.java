package AutumnPlan_2023.day_3_21;

// @date 2023/3/21
// @time 21:19
// @author zhangzhi
// @description LeetCode 18. 四数之和

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _4Sum {

    /**
     * 思路和三数之和是一致的
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for(int a = 0; a < nums.length; a++){
            // 这里不能像三数之和那样判断，因为三数之和的 target 是确定的，而这里的 target 是给定的
            // 四数之和这道题目 target是任意值。比如：数组是[-4, -3, -2, -1]，target是-10，不能因为-4 > -10而跳过。
            // 但是我们依旧可以去做剪枝，逻辑变成 nums[i] > target && (nums[i] >=0 || target >= 0)就可以了。
            if(nums[a] > target && nums[a] >= 0){
                break;
            }
            if(a > 0 && nums[a] == nums[a - 1]){
                continue;
            }
            for(int b = a + 1; b < nums.length; b++){
                if(b > a && nums[b] == nums[b - 1]){
                    continue;
                }
                int left = b + 1;
                int right = nums.length - 1;
                while(left < right){
                    if(nums[a] + nums[b] + nums[left] + nums[right] > target){
                        right--;
                    }else if(nums[a] + nums[b] + nums[left] + nums[right] < target){
                        left++;
                    }else{
                        List<Integer> re = new ArrayList<>(4);
                        re.add(nums[a]);
                        re.add(nums[b]);
                        re.add(nums[left]);
                        re.add(nums[right]);
                        ans.add(re);
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }

                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
