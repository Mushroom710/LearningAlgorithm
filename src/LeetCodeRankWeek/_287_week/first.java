package LeetCodeRankWeek._287_week;

import java.util.Arrays;

/**
 * @DATE 2022/4/3
 * @TIME 10:58
 * @Created by zhangzhi
 * @description LeetCode 6055 题 转化时间需要的最少操作数
 * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，
 * 而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。
 * 你可以执行这一操作 任意 次数。
 * 返回将 current 转化为 correct 需要的 最少操作数 。
 *
 */
public class first {

    /**
     * @create zhangzhi
     * @date 2022/4/3
     * @time 12:07
     * @description DP 问题
     * 思路：初次看到的时候，还没想出来怎么定义状态。因为这两个是字符串，不太好操作
     * 然后，突然灵光一现，把时间转换成一个分钟来表示：11:00 --> 660 min
     * 这样就很好定义状态了。
     * 例如：cur= 11:00 --> 660 min
     *      cor= 11:01 --> 661 min
     * 即通过添加：1、5、15、60 来把 cur --> cor
     * 这个题有一个对应的原题：332题 零钱兑换
     * 是一样的思路。
     * 只不过，这道题一定有解，而 332 这道题不一定有解
     * 进一步的说，可以转换成爬楼梯问题
     * 转成爬楼梯问题
     *    a.状态定义：
     *        dp[i]：上到 i 级台阶的最少步数
     *    b.递推方程：
     *        dp[i] = min{dp[i - coins[j]]} + 1
     *        解释：
     *        可以从先前的任何一级走上来
     *        走的步数是 coins[j]
     */
    public static int solution(String current,String correct){
        String[] c1 = current.split(":");// 拆分字符串，方便计算 对应的分钟
        String[] c2 = correct.split(":");
        int hour = Integer.parseInt(c1[0]);
        int min = Integer.parseInt(c1[1]);
        int curNum = hour*60 + min;// 把 HH:MM 的时间转为 xxx min
        hour = Integer.parseInt(c2[0]);
        min = Integer.parseInt(c2[1]);
        int corNum = hour*60 + min;
        int diff = corNum - curNum;// 因为 current <= correct，所以计算两个时间的差值，即阶梯数
        int[] opt = new int[]{1,5,15,60};// 可选的加数，即一次可以上几级台阶
        int[] dp = new int[diff + 1];// dp 数组
        Arrays.fill(dp,diff + 1);// 初始化
        dp[0] = 0;// dp[0] 表示最开始不需要上台阶
        for(int i = 1; i <= diff ; i++){// 当前的在第几级台阶
            for(int j = 0; j < opt.length; j++){
                if(opt[j] <= i){// 可选的台阶不能大于当前的所在的台阶。例：在 第 5 级，那就不能选一次上 60 级
                    // 前面的 i-opt[j] 级台阶上来， +1 是多了一种方法数
                    // 本题有四种走法，那么每一种走法都要比较一次，找出最小的
                    dp[i] = Math.min(dp[i],dp[i - opt[j]] + 1);// 从前面的台阶上来
                }
            }
        }
        return dp[diff];
    }

    public static void main(String[] args) {
        String current = "11:00";
        String correct = "11:01";
        System.out.println(solution(current,correct));
    }
}
