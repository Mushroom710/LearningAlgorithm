package SummerPlan_2022.day_6_4;

/**
 * @DATE 2022/6/4
 * @TIME 19:52
 * @Created by zhangzhi
 * @description LeetCode 55 题 跳跃游戏
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover;i++){
            cover = Math.max(i + nums[i],cover);
            if (cover >= nums.length - 1)return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
