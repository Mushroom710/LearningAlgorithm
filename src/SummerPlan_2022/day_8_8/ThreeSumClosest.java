package SummerPlan_2022.day_8_8;

// @DATE 2022/8/8
// @TIME 15:54
// @AUTHOR zhangzhi
// @DESCRIPTION LeetCode 16 题  最接近的三数之和
// 假设数组的长度为 n，我们先枚举 a，它在数组中的位置为 i；
// 为了防止重复枚举，我们在位置 [i+1, n) 的范围内枚举 left 和 right。
//   a+left+right ≥ target，那么就将 left 向左移动一个位置
//   a+left+right < target，那么就将 right 向右移动一个位置

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 1000000007;
        // 枚举 a
        for (int i = 0; i < nums.length; i++){
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            // 使用双指针枚举 b 和 c
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                // 如果和为 target 直接返回答案
                if (sum == target){
                    return sum;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
                // 如果和大于 target，移动 right 对应的指针
                if (sum >= target){
                    // 移动到下一个不相等的元素
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    right--;
                }else {// 如果和小于 target，移动 left 对应的指针
                    // 移动到下一个不相等的元素
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        System.out.println(threeSumClosest(nums,1));
    }

}
