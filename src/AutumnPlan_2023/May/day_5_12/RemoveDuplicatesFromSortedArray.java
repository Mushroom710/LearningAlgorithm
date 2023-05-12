package AutumnPlan_2023.May.day_5_12;

// @date 2023/5/12
// @time 21:53
// @author zhangzhi
// @description LeetCode 26. 删除有序数组中的重复项
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int slow = 1;
        int pre = nums[0];
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[fast] != pre){
                nums[slow++] = nums[fast];
                pre = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
