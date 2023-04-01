package AutumnPlan_2023.March.day_3_5;

// @date 2023/3/5
// @time 21:41
// @author zhangzhi
// @description LeetCode 436. 寻找右区间
// 题目都很难看懂
// 题解看这篇：https://leetcode.cn/problems/find-right-interval/solution/by-fuxuemingzhu-98m1/
// 用到了二分的变种

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {

    private static int findRight(int[] start, int target){
        if(target > start[start.length - 1]){
            return -1;
        }
        int left = 0;
        int right = start.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(target >= start[mid]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public static int[] findRightInterval(int[][] intervals) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[] start = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++){
            map.put(intervals[i][0],i);
            start[i] = intervals[i][0];
        }
        Arrays.sort(start);
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            int idx = findRight(start, intervals[i][1]);
            res[i] = idx == -1 ? -1 : map.get(start[idx]);
        }
        return res;
    }
}
