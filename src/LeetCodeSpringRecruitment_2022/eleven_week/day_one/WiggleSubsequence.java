package LeetCodeSpringRecruitment_2022.eleven_week.day_one;

/**
 * @DATE 2022/5/23
 * @TIME 21:37
 * @Created by zhangzhi
 * @description LeetCode 376 题 摆动序列
 */
public class WiggleSubsequence {

    public static int wiggleMaxLength(int[] nums){
        if (nums.length <= 1)return nums.length;
        int preDiff = 0;// 前一对差值
        int curDiff = 0;// 当前一对差值
        int length = 1;// 记录峰值个数，序列默认序列最右边有一个峰值
        for (int i = 0; i < nums.length - 1; i++){
            curDiff = nums[i + 1] - nums[i];
            // 出现峰值
            if ((curDiff > 0 && preDiff <= 0) || (curDiff <= 0 && preDiff > 0)){
                preDiff = curDiff;
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,4,9,2,5};
        System.out.println(wiggleMaxLength(nums));
    }
}
