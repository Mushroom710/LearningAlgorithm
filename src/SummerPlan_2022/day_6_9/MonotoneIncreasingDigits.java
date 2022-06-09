package SummerPlan_2022.day_6_9;

/**
 * @DATE 2022/6/9
 * @TIME 21:00
 * @Created by zhangzhi
 * @description LeetCode 738 题 单调递增的数字
 */
public class MonotoneIncreasingDigits {

    /**
     * @create zhangzhi
     * @date 2022/6/9
     * @time 21:13
     * @description
     * 例如：98，一旦出现 strNum[i - 1] > strNum[i] 的情况（非单调递增），
     * 首先想让 strNum[i - 1]--，然后 strNum[i]给为9，这样这个整数就是 89，
     * 即小于 98 的最大的单调递增整数。
     * 局部最优：遇到 strNum[i - 1] > strNum[i] 的情况，让 strNum[i - 1]--，
     * 然后 strNum[i]给为9，可以保证这两位变成最大单调递增整数。
     * 全局最优：得到小于等于N的最大单调递增的整数。
     * 但这里局部最优推出全局最优，还需要其他条件，即遍历顺序，和标记从哪一位开始统一改成 9。
     * 因为从前后向遍历会改变已经遍历过的结果！（自己手动模拟一下就知道了）
     * 所以采用从后向前遍历，就可以重复利用上次比较得出的结果了
     */
    public static int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chs = s.toCharArray();
        // flag 用来标记赋值 9 从哪里开始
        // 设置为这个默认值，为了防止第二个 for 循环在 flag 没有被赋值的情况下执行
        int flag = chs.length;
        for (int i = chs.length - 1;i > 0;i--){
            if (chs[i - 1] > chs[i]){
                flag = i;
                chs[i - 1]--;
            }
        }
        for (int i = flag;i < chs.length;i++){
            chs[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chs));
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(98));
    }
}
