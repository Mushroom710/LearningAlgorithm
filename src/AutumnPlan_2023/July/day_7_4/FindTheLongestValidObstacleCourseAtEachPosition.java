package AutumnPlan_2023.July.day_7_4;

import java.util.ArrayList;
import java.util.List;

// @date 2023/7/4
// @time 11:57
// @author zhangzhi
// @description LeetCode 1964. 找出到每个位置为止最长的有效障碍赛跑路线
public class FindTheLongestValidObstacleCourseAtEachPosition {
    private int bsLeft(List<Integer> list, int num){
        int left = 0;
        int right = list.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) < num){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        List<Integer> g = new ArrayList<>();
        int[] ans = new int[n];
        for(int i = 0; i < obstacles.length; i++){
            int idx = bsLeft(g, obstacles[i] + 1);
            if(idx == g.size()){
                g.add(obstacles[i]);
            }else{
                g.set(idx, obstacles[i]);
            }
            ans[i] = idx + 1;
        }
        return ans;
    }
}
