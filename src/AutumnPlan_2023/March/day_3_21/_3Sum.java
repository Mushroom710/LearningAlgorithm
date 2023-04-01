package AutumnPlan_2023.March.day_3_21;

// @date 2023/3/21
// @time 21:02
// @author zhangzhi
// @description LeetCode 15. 三数之和  -- 梦破碎的地方

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        // 为什么要排序？
        // 因为 a + b + c == 0，如果排序后，a > 0，说明就没有满足条件的三元组，所以需要排序。
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            // 这里就是 a ，如果 a > 0，说明就没有满足条件的三元组了
            if(nums[i] > 0){
                break;
            }
            // 去重，对重复的 a 去重
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                // 这里的两个判断用到了 二分的思想
                // 大于就往左边，小于往右边
                if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else{
                    List<Integer> re = new LinkedList<>();
                    re.add(nums[i]);
                    re.add(nums[left]);
                    re.add(nums[right]);

                    ans.add(re);

                    // 对 b 和 c 进行去重
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
        return ans;
    }
}
