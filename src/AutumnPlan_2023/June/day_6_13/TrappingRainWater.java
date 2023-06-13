package AutumnPlan_2023.June.day_6_13;

// @date 2023/6/13
// @time 10:41
// @author zhangzhi
// @description LeetCode 42. 接雨水
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = height[0];
        for(int i = 1; i < n; i++){
            pre[i] = Math.max(pre[i - 1], height[i]);
        }
        suf[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suf[i] = Math.max(suf[i + 1], height[i]);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.min(pre[i], suf[i]) - height[i];
        }
        return ans;
    }
}
