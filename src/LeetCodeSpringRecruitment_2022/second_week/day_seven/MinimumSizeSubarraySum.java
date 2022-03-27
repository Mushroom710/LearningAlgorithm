package LeetCodeSpringRecruitment_2022.second_week.day_seven;

/**
 * @DATE 2022/3/27
 * @TIME 21:07
 * @Created by zhangzhi
 * @description LeetCode 209 题 长度最小的子数组
 */
public class MinimumSizeSubarraySum {

    /**
     * @create zhangzhi
     * @date 2022/3/27
     * @time 21:24
     * @description 暴力法
     * 这道题目暴力解法当然是 两个for循环，然后不断的寻找符合条件的子序列
     */
    public static int solution(int target, int[] nums) {
        int result = Integer.MAX_VALUE; // 结果
        int sum = 0; // 累加
        int len = 0; // 临时长度
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                len++;
                if (sum >= target) {
                    result = Math.min(result, len);
                }
            }
            sum = 0; // 累加完成后要重置
            len = 0;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/27
     * @time 21:31
     * @description 滑动窗口
     * 三件套：
     *  a.窗口内是什么？
     *  b.如何移动窗口的起始位置？
     *  c.如何移动窗口的结束位置？
     * 1.窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
     * 2.窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
     * 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，
     * 3.窗口的起始位置设置为数组的起始位置就可以了。
     */
    public static int solution_two(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int len;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) { // 左边界移动后，窗口内的sum>=target是可能的，这就需要不断的从中找最短的子序列
                len = j - i + 1;
                result = Math.min(result, len);
                sum -= nums[i];// 左边界移动后，从窗口的sum减去nums[i]
                i++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;// result 没有被修改，说明没有符合要求的子序列
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(solution(7, nums));
        System.out.println(solution(7, nums));
    }
}
