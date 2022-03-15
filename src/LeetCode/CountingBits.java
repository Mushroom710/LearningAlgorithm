package LeetCode;

import java.util.Arrays;

/**
 * @DATE 2022/3/15
 * @TIME 21:04
 * @Created by zhangzhi
 * @description LeetCode 338 题 比特位计数
 * 1.公式：x = x & (x - 1) 清除最后的一位 1
 *  不断对一个数进行迭代，直到 x == 0
 *  记录迭代的次数，就可以得出 x 的二进制中 1 的个数
 * 2. count[i] = count[i & (i - 1)] + 1
 *  这个递推式子怎么来的呢？
 *  数分为奇数和偶数
 *  对于奇数：最低为一定是 1
 *  对于偶数：最低位一定是 0
 *  例：
 *  0   0   0       1   1   1
 *  2   10  1       3   11  2
 *  4   100 1       5   101 2
 *  6   110 2       7   111 3
 *  显然：奇数的二进制位数 = 前一个偶数的二进制位数 + 1
 *  对于奇数而言：i&(i-1) 就等同于找到它的前一个偶数
 *  抽象出来：count[i] = count[i&[i - 1]] + 1
 *  通过数学归纳法：这个式子对偶数的情况同样成立
 */
public class CountingBits {

    public static int[] solution(int n) {
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            count[i] = count[i & (i - 1)] + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5)));
    }
}
