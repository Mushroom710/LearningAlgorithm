package LeetCodeRankWeek._298_week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/6/19
 * @TIME 10:44
 * @Created by zhangzhi
 * @description
 */
public class second {

    static int min;
    static int sum;
    static List<Integer> path;
    public static void backtracking(int num,int startIdx,int[] nums){
        if (sum == num){
            min = Math.min(min,path.size());
//            System.out.println(path.toString());
        }
        for (int i = startIdx;i < nums.length;i++){
            if (sum + nums[i] > num)break;
            sum += nums[i];
            path.add(nums[i]);
            backtracking(num,i,nums);
            sum -= nums[i];
            path.remove(path.size() - 1);
        }
    }

    public static int minimumNumbers(int num, int k) {
        if (num == 0)return 0;
        ArrayList<Integer> list = new ArrayList<>();
//        if (k == 0)k = 10;
        for (int i = k;i <=3000;i+=10){
            list.add(i);
        }
        int[] nums = new int[list.size() + 1];
        for (int i = 0;i < list.size();i++){
            nums[i] = list.get(i);
        }
        path = new ArrayList<>();
        sum = 0;
        min = Integer.MAX_VALUE;
//        backtracking(num,0,nums);
//        return min == Integer.MAX_VALUE ? -1 : min;
        back(nums,num);
        return 0;
    }

    public static void back(int[] nums,int num){
        int[][] dp = new int[2][num + 1];
        dp[0][1] = 1;
        for (int i = 0;i < nums.length;i++){
            for (int j = nums[i];j <= num;j++){
//                int temp = dp[1][j];
                dp[0][j] += dp[0][j - nums[i]];
//                if (dp[1][j] < dp[1][j - nums[i]] + 1){
//                    dp[1][j] = dp[1][j - nums[i]] + 1;
//                }else {
//                    dp[1][j] = temp;
//                }
            }
            System.out.println(Arrays.toString(dp[0]));
//            System.out.println(Arrays.toString(dp[1]));
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumNumbers(3000,0));
    }
}
