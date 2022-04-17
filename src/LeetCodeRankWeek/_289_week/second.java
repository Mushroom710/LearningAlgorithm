package LeetCodeRankWeek._289_week;

import java.util.Arrays;

/**
 * @DATE 2022/4/17
 * @TIME 15:33
 * @Created by zhangzhi
 * @description
 */
public class second {

    public static int search_right(int[] tasks,int target){
        int left = 0;
        int right = tasks.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (tasks[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    public static int search_left(int[] tasks,int target){
        int left = 0;
        int right = tasks.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (tasks[middle] >= target) {
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }

    public static int binarySearch(int[] nums, int target, boolean leftOrRight) {
        int res = -1;
        int left = 0, right = nums.length - 1, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(target < nums[mid])
                right = mid - 1;
            else if(target > nums[mid])
                left = mid + 1;
            else {
                res = mid;
                //处理target == nums[mid]
                if(leftOrRight)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return res;
    }

    public static int recursion(int num){
        if (num == 1 || num == 2 || num == 3){
            return 1;
        }
        return 1 + recursion(num - 3);
    }

    public static int solution(int[] tasks){
        Arrays.sort(tasks);
        int i = 0;
        int count = 0;
        while (i < tasks.length){
            int num = tasks[i];
            int left = binarySearch(tasks,num,true);
            int right = binarySearch(tasks,num,false);
            int len = right - left + 1;
            if (len < 2){
                return -1;
            }
            count += recursion(len);
            i = right + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] tasks = new int[]{5,5,5,5};
        System.out.println(solution(tasks));
    }
}
