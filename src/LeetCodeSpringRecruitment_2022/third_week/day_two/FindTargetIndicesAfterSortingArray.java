package LeetCodeSpringRecruitment_2022.third_week.day_two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/3/29
 * @TIME 16:51
 * @Created by zhangzhi
 * @description LeetCode 2089 题 找出数组排序后的目标下标
 */
public class FindTargetIndicesAfterSortingArray {

    /**
     * @create zhangzhi
     * @date 2022/3/29
     * @time 17:05
     * @description 暴力法。先排序，然后枚举满足条件的元素
     */
    public static List<Integer> solution(int[] nums, int target){
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                list.add(i);
            }
        }
        return list;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/29
     * @time 17:28
     * @description 先排序，然后二分查找左右边界
     */
    public static List<Integer> solution_two(int[] nums,int target){
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        if(nums[0] > target || nums[len - 1] < target){
            return list;
        }
        // 找左边界
        while (l <= r){
            int mid = (r - l)/2 + l;
            if (nums[mid] >= target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        int left = l;
        l = 0;
        r = len - 1;
        // 找右边界
        while (l <= r){
            int mid = (r - l)/2 + l;
            if(nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        for (int i = left; i <= r; i++){
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,2,3};
//        System.out.println(solution(nums,2));
        System.out.println(solution_two(nums,2));
    }
}
