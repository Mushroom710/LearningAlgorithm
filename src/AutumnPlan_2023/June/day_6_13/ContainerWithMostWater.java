package AutumnPlan_2023.June.day_6_13;

// @date 2023/6/13
// @time 10:41
// @author zhangzhi
// @description LeetCode 11. 盛最多水的容器
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int cap = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, cap);
            if(height[left] < height[right]){
                left += 1;
            }else{
                right -= 1;
            }
        }
        return ans;
    }
}
