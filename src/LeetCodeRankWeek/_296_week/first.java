package LeetCodeRankWeek._296_week;

/**
 * @DATE 2022/6/5
 * @TIME 9:59
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static int minMaxGame(int[] nums) {
        if (nums.length == 1)return nums[0];
        int n = nums.length / 2;
        while (n != 0){
            int[] newNums = new int[n];
            for (int i = 0; i < n;i++){
                if (i % 2 == 0){
                    newNums[i] = Math.min(nums[2 * i],nums[2 * i + 1]);
                }else {
                    newNums[i] = Math.max(nums[2 * i],nums[2 * i + 1]);
                }
            }
            nums = newNums;
            n = nums.length / 2;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{93,40};
        System.out.println(minMaxGame(nums));
    }
}
