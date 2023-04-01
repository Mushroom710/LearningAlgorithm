package AutumnPlan_2023.March.day_3_11;

// @date 2023/3/11
// @time 21:56
// @author zhangzhi
// @description LeetCode 442. 数组中重复的数据

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public static List<Integer> findDuplicates(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != nums[nums[i] - 1]){
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 != i){
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates2(nums).toString());
    }

}
