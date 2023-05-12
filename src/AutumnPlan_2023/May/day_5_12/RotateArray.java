package AutumnPlan_2023.May.day_5_12;

// @date 2023/5/12
// @time 22:15
// @author zhangzhi
// @description LeetCode 189. 轮转数组
// 这题的 k 并不会比数组长度小。所以需要找出轮转的规律。
// 通过一个示例可以得出，k > len(nums) 时，其真正轮转的 k 其实为 k%len(nums)
public class RotateArray {
    private void reverse(int start, int end, int[] nums){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, (k % n) - 1, nums);
        reverse(k % n, nums.length - 1, nums);
    }
}
