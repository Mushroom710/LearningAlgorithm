package LeetCodeSpringRecruitment_2022.third_week.day_three;

/**
 * @DATE 2022/3/30
 * @TIME 16:28
 * @Created by zhangzhi
 * @description LeetCode 33 题 搜索旋转数组
 */
public class SearchInRotatedSortedArray {

    /**
     * @create zhangzhi
     * @date 2022/3/30
     * @time 16:54
     * @description 先暴力找到旋转的下标位置，然后再二分
     */
    public static int solution(int[] nums, int target) {
        int idx = 1;
        int len = nums.length;
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // 先找到旋转的下标位置
        for (; idx < len; idx++) {
            if (nums[idx - 1] > nums[idx]) {
                break;
            }
        }
        // 如果旋转了，就分为两部分查找
        if (idx != len) {
            idx--;
            if (nums[idx] < target || nums[idx + 1] > target) {
                return -1;
            }
            int left = 0;
            int right = idx;
            int mid = BinarySearch(nums, target, left, right);
            if (mid != -1) return mid;

            left = idx + 1;
            right = len - 1;
            mid = BinarySearch(nums, target, left, right);
            return mid;
        }else {// 没有旋转，说明数组本身有序
            return BinarySearch(nums,target,0,len - 1);
        }
    }

    /**
     * @create zhangzhi
     * @date 2022/3/30
     * @time 16:53
     * @description 二分查找
     */
    private static int BinarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,1,2,3};
        System.out.println(solution(nums, 2));
    }
}
