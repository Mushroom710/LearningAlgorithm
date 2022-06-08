package SummerPlan_2022.day_6_8;

import java.util.Arrays;

/**
 * @DATE 2022/6/8
 * @TIME 9:56
 * @Created by zhangzhi
 * @description LeetCode 435 题 无重叠区间
 * 1.按照右边界排序，就要从左向右遍历，因为右边界越小越好，只要右边界越小，
 * 留给下一个区间的空间就越大，所以从左向右遍历，优先选右边界小的。
 * 2.按照左边界排序，就要从右向左遍历，因为左边界数值越大越好（越靠右），
 * 这样就给前一个区间的空间就越大，所以可以从右向左遍历。
 * 按照右边界排序，从左向右记录非交叉区间的个数。
 * 最后用区间总数减去非交叉区间的个数就是需要移除的区间个数了
 * 左边界同理
 * 每次取非交叉区间的时候，都是找右边界最小的来做分割点（这样留给下一个区间的空间就越大），
 * 所以第一条分割线就是区间 1结束的位置。
 *
 * 难点一：一看题就有感觉需要排序，但究竟怎么排序，按左边界排还是右边界排。
 * 难点二：排完序之后如何遍历，如果没有分析好遍历顺序，那么排序就没有意义了。
 * 难点三：直接求重复的区间是复杂的，转而求最大非重复区间个数。
 * 难点四：求最大非重复区间个数时，需要一个分割点来做标记。
 */
public class NonoverlappingIntervals {

    /**
     * @create zhangzhi
     * @date 2022/6/8
     * @time 10:09
     * @description 有点想当然了
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {
            if (a[0] == b[0])return a[1]-b[1];
            return a[0] - b[0];
        });
        int count = 0;
        for (int i = 1;i < intervals.length;i++){
            if (intervals[i - 1][1] > intervals[i][0]){
                count++;
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = intervals[i - 1][1];
            }
        }
        return count;
    }

    public static int right_solution(int[][] intervals){
        if (intervals.length == 0)return 0;
        Arrays.sort(intervals,(a,b) -> {
            if (a[0] == b[0])return a[1]-b[1];
            return a[0] - b[0];
        });
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1;i < intervals.length;i++){
            if (end <= intervals[i][0]){
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

    public static int left_solution(int[][] intervals){
        if (intervals.length == 0)return 0;
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int count = 1;
        int left = intervals[intervals.length - 1][0];
        for (int i = intervals.length - 2;i>=0;i--){
            if (left >= intervals[i][1]){
                left = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{2,3}};
//        System.out.println(eraseOverlapIntervals(intervals));
//        System.out.println(right_solution(intervals));
        System.out.println(left_solution(intervals));
    }
}
