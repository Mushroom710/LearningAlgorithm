package ProgrammerCarl.ArrayChapter;

/**
 * @DATE 2022/3/25
 * @TIME 9:18
 * @Created by zhangzhi
 * @description 二分查找
 * 问题：
 * 大家写二分法经常写乱，主要是因为对区间的定义没有想清楚，区间的定义就是不变量。
 * 要在二分查找的过程中，保持不变量，
 * 就是在while寻找中每一次边界的处理都要坚持根据区间的定义来操作，
 * 这就是循环不变量规则。
 * 1.第一种写法，我们定义 target 是在一个在左闭右闭的区间里，也就是[left, right] （这个很重要非常重要）。
 *    区间的定义这就决定了二分法的代码应该如何写，因为定义target在[left, right]区间，所以有如下两点：
 *       while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
 *       if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，
 *       那么接下来要查找的左区间结束下标位置就是 middle - 1
 *
 * 2.如果说定义 target 是在一个在左闭右开的区间里，也就是[left, right) ，那么二分法的边界处理方式则截然不同。
 *      while (left < right)，这里使用 < ,因为left == right在区间[left, right)是没有意义的
 *      if (nums[middle] > target) right 更新为 middle，因为当前nums[middle]不等于target，去左区间继续寻找，
 *      而寻找区间是左闭右开区间，所以right更新为middle，即：下一个查询区间不会去比较nums[middle]
 */
public class BinarySearch {

    /**
     * @create zhangzhi
     * @date 2022/3/25
     * @time 9:27
     * @description 第一种写法：左闭右闭区间
     */
    public static int Search_One(int[] nums, int target){
        if(target < nums[0] || target > nums[nums.length -1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/25
     * @time 9:30
     * @description 第二种写法：左闭右开区间
     */
    public static int Search_Two(int[] nums, int target){
        if(target < nums[0] || target > nums[nums.length -1]){
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,7,9,10};
        System.out.println(Search_One(nums,-1));
        System.out.println(Search_Two(nums,-1));
    }
}
