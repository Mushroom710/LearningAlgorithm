package SummerPlan_2022.day_6_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/6/8
 * @TIME 10:56
 * @Created by zhangzhi
 * @description LeetCode 56 题 合并区间
 * 这题按照左边界或右边界排序都可以
 */
public class MergeIntervals {

    /**
     * @create zhangzhi
     * @date 2022/6/8
     * @time 11:12
     * @description
     * 按照右边界排序
     * 每次找最大的右边界，记录下 最左和最大右边界
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {
            if (a[0] == b[0])return a[1]-b[1];
            return a[0]-b[0];
        });
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1;i < intervals.length;i++){
            // 判断区间是否重合
            if (end >= intervals[i][0]){
                // 在重合的区间中找最大右边界
                end = Math.max(intervals[i][1], end);
            }else {// 不重合，合并之前的区间
                list.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        int[][] ans = new int[list.size() + 1][2];
        for (int i = 0;i < list.size();i++){
            ans[i] = list.get(i);
        }
        // 最后一个区间需要手动添加
        ans[list.size()] = new int[]{start,end};
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
