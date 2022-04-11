package LeetCodeSpringRecruitment_2022.five_week.day_one;

/**
 * @DATE 2022/4/11
 * @TIME 21:52
 * @Created by zhangzhi
 * @description LeetCode 81 题 搜索旋转排序数组 II
 * 思路：
 *  先找到旋转的下标位置，同时还可判断是否有target，然后再对剩下的数组进行二分查找。
 */
public class SearchInRotatedSortedArrayII {

    /**
     * @create zhangzhi
     * @date 2022/4/11
     * @time 22:00
     * @description 二分查找
     */
    private static boolean binarySearch(int[] nums,int left,int right,int target){
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * @create zhangzhi
     * @date 2022/4/11
     * @time 22:00
     * @description 先找到旋转的下标位置，同时还可判断是否有target，然后再对剩下的数组进行二分查找。
     */
    public static boolean solution(int[] nums,int target){
        int max = nums[0];
        int len = nums.length;
        int k = 0;
        // 找到旋转的下标
        while (k < len){
            // 同时还可以在寻找的过程中判断是否有 target
            if(nums[k] == target){
                return true;
            }
            if(nums[k] >= max){
                max = nums[k];
            }else {
                break;
            }
            k++;
        }
        // 没找到的话，就在剩下的数组里进行二分查找
        return binarySearch(nums,k-1,len - 1,target);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,6,0,0,1,2};
        System.out.println(solution(nums,-1));
    }
}
