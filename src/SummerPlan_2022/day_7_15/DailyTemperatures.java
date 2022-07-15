package SummerPlan_2022.day_7_15;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @DATE 2022/7/15
 * @TIME 20:37
 * @Created by zhangzhi
 * @description LeetCode 739 每日温度
 */
public class DailyTemperatures {

    private static void simple(int[] ans,int[] temperatures,Deque<Integer> deque,int idx){
        while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[idx]){
            int tmp = deque.pollLast();
            ans[tmp] = idx - tmp;
        }
        deque.addLast(idx);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0;i < temperatures.length;i++){
            if (deque.isEmpty() || temperatures[deque.peekLast()] >= temperatures[i]){
                deque.addLast(i);
            }else {
                simple(ans,temperatures,deque,i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{89,62,70,58,47,47,46,76,100,70};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
