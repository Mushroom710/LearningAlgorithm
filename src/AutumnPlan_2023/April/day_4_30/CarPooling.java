package AutumnPlan_2023.April.day_4_30;

import java.util.Arrays;
import java.util.Comparator;

// @date 2023/4/30
// @time 22:06
// @author zhangzhi
// @description LeetCode 1094. 拼车
public class CarPooling {

    public static boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] == o2[2]){
                    return o1[1] - o2[1];
                }
                return o1[2] - o2[2];
            }
        });
        for(int i = 0; i < trips.length; i++){
            if(capacity >= trips[i][0]){
                capacity -= trips[i][0];
            }else{
                return false;
            }
            if(i > 0 && trips[i][2] <= trips[i][1]){
                capacity += trips[i][0];
            }
        }
        return true;
    }

    public static void main(String[] args) {
       int[][] trips = new int[][]{{2,1,5},{3,3,7}};
       int capacity = 4;
        System.out.println(carPooling(trips, capacity));
    }
}
