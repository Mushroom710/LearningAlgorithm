package AutumnPlan_2023.May.day_5_13;

import java.util.Arrays;

// @date 2023/5/13
// @time 12:48
// @author zhangzhi
// @description LeetCode 274. H 指数 这个题目的描述绕的一匹。
// 本质就是排序后，从后往前枚举，找出 >h 的篇数。
// h 初始化为 0，枚举citations，如果citation[i] > h，h++，n--。枚举下一篇
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int n = citations.length - 1;
        while(n >= 0 && citations[n] > h){
            h++;
            n--;
        }
        return h;
    }
}
