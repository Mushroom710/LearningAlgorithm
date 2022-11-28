package AutumnPlan_2022.day_11_28;

// @date 2022/11/28
// @time 21:47
// @author zhangzhi
// @description LeetCode 18 题 四数之和
// 和三数之和是一样的思路，固定一个值，搜索另外两个值

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _4Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int k = 0; k < nums.length; k++){
            // 剪枝处理
            if(nums[k] > target && target > 0){
                break;
            }
            // 对nums[k]去重
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            for(int i = k + 1; i < nums.length; i++){
                // 这里就把 nums[k] + nums[i] 看做一个值
                // 2级剪枝处理
                if(nums[k] + nums[i] > target && nums[k] + nums[i] > 0){
                    break;
                }
                // 对nums[i]去重
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right){
                    // 注意整数溢出
                    if((long)nums[k] + nums[i] + nums[left] + nums[right] > target){
                        right--;
                    }else if((long)nums[k] + nums[i] + nums[left] + nums[right] < target){
                        left++;
                    }else{
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[k]);
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        // 对nums[left]和nums[right]去重
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2};
        fourSum(nums, 8);
    }
}
