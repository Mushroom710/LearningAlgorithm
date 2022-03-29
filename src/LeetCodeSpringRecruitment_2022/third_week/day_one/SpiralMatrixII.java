package LeetCodeSpringRecruitment_2022.third_week.day_one;

import java.util.Arrays;

/**
 * @DATE 2022/3/28
 * @TIME 11:11
 * @Created by zhangzhi
 * @description LeetCode 59 题 螺旋矩阵 II
 * 这道题本身不难，难就难在怎么循环填充每一条边
 * 而求解本题依然是要坚持循环不变量原则。
 * <p>
 * 模拟顺时针画矩阵的过程:
 * 1.填充上行从左到右
 * 2.填充右列从上到下
 * 3.填充下行从右到左
 * 4.填充左列从下到上
 * 由外向内一圈一圈这么画下去。
 * 可以发现这里的边界条件非常多，在一个循环中，如此多的边界条件，
 * 如果不按照固定规则来遍历，那就是一进循环深似海，从此offer是路人。
 * 这里一圈下来，我们要画四条边，这四条边怎么画，
 * 每画一条边都要坚持一致的左闭右开，或者左开右闭的原则，
 * 这样这一圈才能按照统一的规则画下来。
 */
public class SpiralMatrixII {

    /**
     * @create zhangzhi
     * @date 2022/3/28
     * @time 11:30
     * @description 非常考验对代码的掌控力
     */
    public static int[][] solution(int n) {
        // 定义每次循环起始位置
        int x = 0;
        int y = 0;
        // 循环次数
        int loop = n / 2;
        // 中间的位置
        int mid = n / 2;
        // 偏移量
        int offset = 1;
        int[][] ans = new int[n][n];
        // 填充的数字
        int count = 1;
        while (loop > 0) {
            int i = x;
            int j = y;
            // 模拟上侧 从 左到右
            for (; j < y + n - offset; j++) {
                ans[x][j] = count;
                count++;
            }
            // 模拟右侧 从 上到下
            for (; i < x + n - offset; i++) {
                ans[i][j] = count;
                count++;
            }
            // 模拟下侧 从 右到左
            for (; j > y; j--) {
                ans[i][j] = count;
                count++;
            }
            // 模拟左侧 从 下到上
            for (; i > x; i--) {
                ans[i][j] = count++;
            }
            // 初始位置更改到下一个循环圈
            x++;
            y++;
            // 偏移量 加 2 因为每一条边画都是 n - 2
            offset += 2;
            // 循环圈数减一
            loop--;
        }
        if (n % 2 == 1) {
            ans[mid][mid] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(1)));
    }
}
