package SummerPlan_2022.day_8_1;

// @DATE 2022/8/1
// @TIME 20:32
// @AUTHOR zhangzhi
// @DESCRIPTION 接雨水

import java.util.Stack;

public class TrappingRainWater {

    public static int trap(int[] height) {
        if (height.length <= 2)return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++){
            if (height[i] < height[stack.peek()]){
                stack.push(i);
            }else if (height[i] == height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else{
                while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                    int mid = stack.pop();
                    if (!stack.isEmpty()){
                        int h = Math.min(height[i], height[stack.peek()]) - height[mid];
                        int w = i - stack.peek() - 1;
                        sum += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}
