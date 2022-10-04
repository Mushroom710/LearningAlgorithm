package AutumnPlan_2022.day_10_4;

// @date 2022/10/4
// @time 19:47
// @author zhangzhi
// @description LeetCode 84 题 柱状图中最大的矩形


import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        stack.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 0; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.peek()] 比较 ，st.peek()是下标
            if(heights[i] > heights[stack.peek()]){
                stack.push(i);
            }else if(heights[i] == heights[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else {
                while (heights[i] < heights[stack.peek()]){ // 注意是while
                    int mid = stack.pop();
                    int left = stack.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4};
        System.out.println(largestRectangleArea(nums));
    }
}
