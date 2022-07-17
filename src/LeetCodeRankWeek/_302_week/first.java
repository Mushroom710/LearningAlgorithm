package LeetCodeRankWeek._302_week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @DATE 2022/7/17
 * @TIME 10:12
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static int[] numberOfPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0;i < nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans[0] += entry.getValue() / 2;
            ans[1] += entry.getValue() % 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,1,3,2,2};
        System.out.println(Arrays.toString(numberOfPairs(nums)));
    }
}
