package LeetCodeRankWeek._305_week;

// @DATE 2022/8/7
// @TIME 10:28
// @AUTHOR zhangzhi
// @DESCRIPTION

import java.util.ArrayList;
import java.util.List;

public class first {

    private static int binarySearch(int[] nums, int start, int end, int num){
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == num){
                return mid;
            }else if (nums[mid] < num){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int idx = binarySearch(nums,i + 1,nums.length - 1,nums[i] + diff);
            if ( idx != -1) {
                int idx2 = binarySearch(nums,idx + 1,nums.length - 1,nums[idx] + diff);
                if (idx2 != -1) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(i);
                    list1.add(idx);
                    list1.add(idx2);
                    list.add(list1);
                }
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,8,9};
        System.out.println(arithmeticTriplets(nums,2));
    }
}
