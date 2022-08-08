package SummerPlan_2022.day_8_8;

// @DATE 2022/8/8
// @TIME 15:20
// @AUTHOR zhangzhi
// @DESCRIPTION LeetCode 11 题 盛最多水的容器

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int w = j - i;
                if (h * w > max){
                    max = h * w;
                }
            }
        }
        return max;
    }

    /**
     * 根据 min(height[r],height[l]) * (r - l) 来看，每次需要移动变化小的那个！
     * 移动小的变化率不会超过移动大的那个
     * @param height
     * @return
     */
    public static int rightSolution(int[] height){
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int capacity = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, capacity);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,1};
        System.out.println(maxArea(height));
        System.out.println(rightSolution(height));
    }
}
