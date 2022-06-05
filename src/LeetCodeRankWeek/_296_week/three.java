package LeetCodeRankWeek._296_week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @DATE 2022/6/5
 * @TIME 10:59
 * @Created by zhangzhi
 * @description
 */
public class three {

    public static int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i = 0;i < operations.length;i++){
            int idx = map.get(operations[i][0]);
            map.remove(operations[i][0]);
            nums[idx] = operations[i][1];
            map.put(operations[i][1],idx);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,6};
        int[][] opera = new int[][]{{1,3},{4,7},{6,1}};
        System.out.println(Arrays.toString(arrayChange(nums,opera)));
    }
}
