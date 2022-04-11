package LeetCodeSpringRecruitment_2022.five_week.day_one;

/**
 * @DATE 2022/4/11
 * @TIME 22:07
 * @Created by zhangzhi
 * @description LeetCode 162 题 寻找峰值
 * 思路：
 *  因为 nums[-1] = nums[n] = 负无穷
 *  所以可以首先判断，nums[0]和 nums[n - 1] 是不是峰值，
 *  这样就可以很好的处理二分查找时的边界处理问题。
 *  同时还要注意到数组长度为 1 的情况，这种就可以直接返回
 */
public class FindPeakElement {

    /**
     * @create zhangzhi
     * @date 2022/4/11
     * @time 22:22
     * @description 二分查找 峰值
     */
    private static int binarySearch(int[] nums,int left,int right){
        while (left <= right){
            int mid = left + (right - left) / 2;
            // 峰值要同时大于左边和右边
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(nums[mid] < nums[mid - 1]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return 0;
    }

    /**
     * @create zhangzhi
     * @date 2022/4/11
     * @time 22:25
     * @description 为什么要事先判断 下标 0 和 len - 1 的位置呢？
     * 因为事先判断后，在进行二分查找的时候，边界问题就可以很好的处理掉
     * 所以事先判断好这两个位置，在二分查找的时候，写代码的逻辑就很容易
     */
    public static int solution(int[] nums){
        // 注意数组长度为 1 的情况
        // 判断数组两边是不是峰值
        if(nums.length == 1 || nums[0] > nums[1]){
            return 0;
        }else if(nums[nums.length - 1] > nums[nums.length - 2]){
            return nums.length - 1;
        }
        // 两边都不是，就可以在 [1,len - 2] 的范围内进行二分查找
        // 这是因为 下标 0 和 len - 1 的位置在前面已经判断过了
        return binarySearch(nums,1,nums.length - 2);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,5,6,4};
        System.out.println(solution(nums));
    }
}
