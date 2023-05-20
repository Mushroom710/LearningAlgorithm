package AutumnPlan_2023.May.day_5_20;

// @date 2023/5/20
// @time 10:18
// @author zhangzhi
// @description LeetCode 11. 盛最多水的容器
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int cap = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r){
            cap = Math.max(cap, (r - l) * Math.min(height[r], height[l]));
            if(height[r] > height[l]){
                l++;
            }else{
                r--;
            }
        }
        return cap;
    }
}
