package AutumnPlan_2023.March.day_3_13;

// @date 2023/3/13
// @time 21:21
// @author zhangzhi
// @description LeetCode 27. 移除元素

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int slow = 0;
        for(int fast = 0; fast < len; fast++){
            if(val != nums[fast]){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElement(nums, 3));
    }
}
