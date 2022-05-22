package LeetCodeRankWeek._294_week;

import java.util.Arrays;

/**
 * @DATE 2022/5/22
 * @TIME 10:43
 * @Created by zhangzhi
 * @description
 */
public class second {

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks){
        int n = capacity.length;
        int[] diff = new int[n];
        for (int i = 0; i < n;i++){
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int count = 0;
        int add = additionalRocks;
        for (int i = 0;i < n;i++){
            if (add >= 0 && diff[i] <= add){
                count++;
                add -= diff[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
