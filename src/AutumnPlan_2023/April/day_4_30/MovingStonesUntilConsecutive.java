package AutumnPlan_2023.April.day_4_30;

import java.util.Arrays;

// @date 2023/4/30
// @time 21:36
// @author zhangzhi
// @description LeetCode 1033. 移动石子直到连续
// 排序。
// 计算出相邻两个数的距离，求和，就是最大移动次数。
// 最小移动次数，如果出现left=1或者right=1，那么最小次数就是1。否则就是其他情况，2或者1或者0。
public class MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        int[] idxs = new int[]{a, b, c};
        Arrays.sort(idxs);
        int left = idxs[1] - idxs[0] - 1;
        int right = idxs[2] - idxs[1] - 1;
        int max = left + right;
        int min = 0;
        if(left == 1 || right == 1){
            return new int[]{1, max};
        }
        if(left > 0){
            min += 1;
        }
        if(right > 0){
            min += 1;
        }
        return new int[]{min, max};
    }
}
