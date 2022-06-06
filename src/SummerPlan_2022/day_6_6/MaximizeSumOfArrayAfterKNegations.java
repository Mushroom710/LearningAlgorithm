package SummerPlan_2022.day_6_6;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @DATE 2022/6/6
 * @TIME 21:56
 * @Created by zhangzhi
 * @description LeetCode 1005 题 K次取反后最大化的数组和
 */
public class MaximizeSumOfArrayAfterKNegations {

    /**
     * @create zhangzhi
     * @date 2022/6/6
     * @time 22:27
     * @description 寄了，每调出来
     */
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int i = 0;
        for (i = 0; i < nums.length && i < k;i++){
            if (nums[i] < 0){
                nums[i] = -nums[i];
            }else {
                if (i > 0 && nums[i - 1] > nums[i]) {
                    if ((k - i) % 2 == 0) {
                        break;
                    } else {
                        nums[i] = -nums[i];
                        break;
                    }
                }else {
                    if ((k - i) % 2 == 0) {
                        break;
                    } else {
                        if (i == 0){
                            nums[0] = -nums[0];
                            break;
                        }
                        nums[i - 1] = -nums[i - 1];
                        break;
                    }
                }
            }
        }
        if (i > 0 && i < k){
            if ((k - i) % 2 != 0){
                nums[i - 1] = -nums[i - 1];
            }
        }
        int sum = 0;
        for (i = 0;i < nums.length;i++){
            sum += nums[i];
        }
        return sum;
    }

    public static int right_solution(int[] nums,int k){
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0;i < len;i++){
            if (nums[i] < 0 && k > 0){
                nums[i] *= -1;
                k--;
            }
        }
        if (k % 2 == 1)nums[len - 1] *= -1;
        int sum = 0;
        for (int i = 0;i < len;i++){
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,-3};
        System.out.println(largestSumAfterKNegations(nums,4));
        System.out.println(right_solution(nums,4));
    }
}
