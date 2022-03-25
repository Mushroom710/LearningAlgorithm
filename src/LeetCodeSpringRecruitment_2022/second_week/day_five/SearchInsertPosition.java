package LeetCodeSpringRecruitment_2022.second_week.day_five;

/**
 * @DATE 2022/3/25
 * @TIME 15:03
 * @Created by zhangzhi
 * @description LeetCode 35 题 搜索插入位置
 * 四种情况：
 *      1.目标值在数组所有元素之前
 *      2.目标值等于数组中某一个元素
 *      3.目标值插入数组中的位置
 *      4.目标值在数组所有元素之后
 */
public class SearchInsertPosition {

    /**
     * @create zhangzhi
     * @date 2022/3/25
     * @time 15:04
     * @description 采用左闭右闭写法
     * 实在看不明白，就拿笔写一写
     */
    public static int solution(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前  [0, -1]
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置 [left, right]，return  right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， return right + 1
        return right + 1;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/25
     * @time 15:12
     * @description 暴力解法
     */
    public static int solution_two(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            // 分别处理如下三种情况
            // 目标值在数组所有元素之前
            // 目标值等于数组中某一个元素
            // 目标值插入数组中的位置
            if(nums[i] >= target){// 一旦发现大于或者等于target的num[i]，那么i就是我们要的结果
                return i;
            }
        }
        // 目标值在数组所有元素之后的情况
        return nums.length;// 如果target是最大的，或者 nums为空，则返回nums的长度
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(solution(nums,9));
        System.out.println(solution_two(nums,9));
    }
}
