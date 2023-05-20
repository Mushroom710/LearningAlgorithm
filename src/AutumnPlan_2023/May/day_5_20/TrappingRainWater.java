package AutumnPlan_2023.May.day_5_20;

// @date 2023/5/20
// @time 10:25
// @author zhangzhi
// @description LeetCode 42. 接雨水
public class TrappingRainWater {
    public int trap(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        int l_height = height[0];
        int r_height = height[r];
        while(l < r){
            if(l_height < r_height){
                ans += l_height - height[l];
                l++;
            }else{
                ans += r_height - height[r];
                r--;
            }
            l_height = Math.max(l_height, height[l]);
            r_height = Math.max(r_height, height[r]);
        }
        return ans;
    }
}
