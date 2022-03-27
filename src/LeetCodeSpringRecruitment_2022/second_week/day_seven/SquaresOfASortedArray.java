package LeetCodeSpringRecruitment_2022.second_week.day_seven;

import java.util.Arrays;

/**
 * @DATE 2022/3/27
 * @TIME 20:41
 * @Created by zhangzhi
 * @description LeetCode 977 题 有序数组的平方
 */
public class SquaresOfASortedArray {

    /**
     * @create zhangzhi
     * @date 2022/3/27
     * @time 20:41
     * @description 暴力法
     * 先平方，后排序
     */
    public static int[] solution(int[] nums){
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/27
     * @time 20:57
     * @description 双指针法
     * 由于有负数的存在，所以平方后有可能成为最大值，而最大值只可能在两边出现
     * 不可能在中间，所以比较两边谁最大，依次放入
     */
    public static int[] solution_two(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[nums.length];
        for(int k = nums.length - 1;left <= right;k--){
            if(nums[left]*nums[left] > nums[right]*nums[right]){
                ans[k] = nums[left]*nums[left];
                left++;
            }else{
                ans[k] = nums[right]*nums[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        System.out.println(Arrays.toString(solution_two(nums)));
    }
}
