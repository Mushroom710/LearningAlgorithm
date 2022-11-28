package AutumnPlan_2022.day_11_28;

// @date 2022/11/28
// @time 21:09
// @author zhangzhi
// @description LeetCode 15 题 三数之和
// 注意有两个维度的去重，一个是下标去重，一个是元素去重

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if(nums[i] > 0){
                return result;
            }
            // 正确去重a方法
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else{
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    // 找到答案时，双指针同时收缩
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
