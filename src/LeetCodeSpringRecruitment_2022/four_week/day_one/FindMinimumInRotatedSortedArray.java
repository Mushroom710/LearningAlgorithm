package LeetCodeSpringRecruitment_2022.four_week.day_one;

/**
 * @DATE 2022/4/4
 * @TIME 20:57
 * @Created by zhangzhi
 * @description LeetCode 153 寻找旋转排序数组中的最小值
 * 旋转后的数组依旧是部分有序，可以应用二分查找
 *
 * AC后内心 os：
 * 要相信自己呀！本以为没有思路的，仔细看了下题目，
 * 其实数组依旧是相对有序的，只不过对二分时的边界移动需要做出一点小的改变。
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * @create zhangzhi
     * @date 2022/4/4
     * @time 20:59
     * @description 牢记循环不变量原则
     * left = 0;right = nums.length - 1;
     * while(left <= right)
     */
    public static int solution(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= min){// 为了避免出现 刚好命中初始时假设的 min
                left = mid + 1;// 如果比min要大，说明左边的都比右边的大，left应该向右移动
            }else{// 说明当前mid所指的小范围内是整个数组最小的子数组部分
                min = nums[mid];//不然，把当前置为min
                right = mid - 1;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{11,1}));
    }
}
