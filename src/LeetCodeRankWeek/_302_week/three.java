package LeetCodeRankWeek._302_week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @DATE 2022/7/17
 * @TIME 11:03
 * @Created by zhangzhi
 * @description
 */
public class three {

    private static void bubble(long[][] nums){
        for (int i = 0;i < nums.length - 1;i++){
            for (int j = 0;j < nums.length - i - 1;j++){
                if (nums[j][0] > nums[j + 1][0]){
                    long[] tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.deepToString(nums));
    }

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
//        Map<Integer,Integer> map = new HashMap<>();
        long[][] numbers = new long[nums.length][2];
        int[] ans = new int[queries.length];
        String tmp = "";
        int idx = 0;
        for (int i = 0;i < queries.length;i++){
            for (int j = 0;j < nums.length;j++){
                tmp = nums[j];
                if (queries[i][1] != nums[j].length()) {
                    tmp = nums[j].substring(nums[j].length() - queries[i][1]);
                }
                if (tmp.length() != 1 && tmp.charAt(0) == '0'){
                    tmp = tmp.substring(1);
                }
                long n = Long.parseLong(tmp);
                numbers[j][0] = n;
                numbers[j][1] = j;
//                if (map.get(n) == null)map.put(n,j);
            }
//            Arrays.sort(numbers);
            bubble(numbers);
//            ans[idx++] = map.get(numbers[queries[i][0] - 1]);
//            map.clear();
            ans[idx++] = Math.toIntExact(numbers[queries[i][0] - 1][1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] nums = new String[]{"24","37","96","04"};
        int[][] queries = new int[][]{{2,1},{2,2}};
        System.out.println(Arrays.toString(smallestTrimmedNumbers(nums,queries)));
    }
}
