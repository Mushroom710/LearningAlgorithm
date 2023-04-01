package AutumnPlan_2023.March.day_3_11;

// @date 2023/3/11
// @time 21:22
// @author zhangzhi
// @description LeetCode 448. 找到所有数组中消失的数字

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    /**
     * 标记法：
     * 用一个标记数组记录出现过的数字，然后遍历标记数组，收集没有出现过的数字。
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] boo = new boolean[n];
        for(int num : nums){
            boo[num - 1] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!boo[i]){
                ans.add(i + 1);
            }
        }
        return ans;
    }


    private static boolean binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 二分查找法。先对数组排序，然后再数组中二分查找 [1,n] 的数字是否在数组中。
     * 如果在，返回 true；不在，返回 false，收集为返回 false 的数字。
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 1; i <= nums.length; i++){
            if(!binarySearch(nums, i)){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers2(nums).toString());
    }
}
