package AutumnPlan_2023.May.day_5_7;

// @date 2023/5/7
// @time 22:24
// @author zhangzhi
// @description 每日一题 LeetCode 1010. 总持续时间可被 60 整除的歌曲
// 简单讲就是，t%60得到余数，然后要找到另一个数与t相加是60的倍数。这就是（60 - t%60）% 60的意义。
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        int ans = 0;
        for(int t : time){
            ans += cnt[(60 - t % 60) % 60];
            cnt[t % 60]++;
        }
        return ans;
    }
}
