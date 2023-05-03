package AutumnPlan_2023.May.day_5_3;

// @date 2023/5/3
// @time 22:21
// @author zhangzhi
// @description LeetCode 1094. 拼车
public class CarPooling {
    // 差分数组
    public boolean carPooling(int[][] trips, int capacity) {
        int to = trips[0][2];
        for(int i = 1; i < trips.length; i++){
            to = Math.max(to, trips[i][2]);
        }
        int[] diff = new int[to + 2];
        for(int i = 0; i < trips.length; i++){
            diff[trips[i][1]] += trips[i][0];
            diff[trips[i][2]] -= trips[i][0];
        }

        int cap = 0;
        for(int i = 0; i < diff.length; i++){
            cap += diff[i];
            if(cap > capacity){
                return false;
            }
        }
        return true;
    }
}
