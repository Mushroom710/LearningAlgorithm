package LeetCodeSpringRecruitment_2022.second_week.day_five;

import java.util.Arrays;

/**
 * @DATE 2022/3/25
 * @TIME 15:26
 * @Created by zhangzhi
 * @description LeetCode 34 题 在排序数组中查找元素的第一个和最后一个位置
 * 例：
 *   输入：nums = [5,7,7,8,8,10], target = 8
 *   输出：[3,4]
 *
 * 1.暴力解法
 *   先遍历数组，找到第一个出现的 target，记录 下标，结束循环
 *   另起一个循环找到右界限
 *   while(nums[right] == target)
 *      right++;
 *
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * @create zhangzhi
     * @date 2022/3/25
     * @time 15:47
     * @description 暴力法
     *  1.先找最左边，再找最右边
     */
    public static int[] solution(int[] nums, int target){
        // 初始化左右边界 ，没有就返回 -1
        int left = -1;
        int right = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){ // 找到最左边出现的第一个
                left = i;
                break;
            }
        }
        if (left == -1){ // 前面的 for 循环没有找到左边界的target，那么直接返回
            return new int[]{-1,-1};
        }

        right = left + 1;// 右边界初始化为左边界加1
        while (right < nums.length && nums[right] == target){// 右边界还要考虑下标越界的可能
            right++;
        }
        // 找到右边界时，是多做了一次 +1 操作，这是就要减去这个 1
        return new int[]{left,right-1};
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(Arrays.toString(solution(nums, 1)));
    }
}
