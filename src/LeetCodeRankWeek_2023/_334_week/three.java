package LeetCodeRankWeek_2023._334_week;

// @date 2023/2/26
// @time 11:10
// @author zhangzhi
// @description 6367. 求出最多标记下标

import java.util.Arrays;

public class three {

    public static int maxNumOfMarkedIndices(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        boolean[] mark = new boolean[nums.length];
        while(i < j){
            int idx = j;
            if(2 * nums[i] <= nums[idx]){
                int tmp = idx;
                while(true){
                    if(mark[idx - 1]){
                       break;
                    }
                    idx--;
                    if(i >= idx || 2 * nums[i] >= nums[idx]){
                        break;
                    }
                }
                mark[i] = true;
                mark[idx] = true;
                count+=2;
            }

            while(i < j){
                i++;
                if(!mark[i]) {
                    break;
                }
            }
            if(i >= j){
                break;
            }
        }
        return count;
    }

    /**
     * 我们需要用左半部分的数去匹配右半部分的数
     * 从右半部分中，找出找到第一个满足 2 * nums[i] <= nums[j] 的 j，那么 nums[1] 此时只能匹配下标大于 j 的数，以此类推。
     * @param nums
     * @return
     */
    public static int maxNumOfMarkedIndices2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int n = nums.length;
        for(int x = (n + 1) / 2; x < n; x++){
            if(2 * nums[i] <= nums[x]){
                i++;
            }
        }
        return i * 2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{57,40,57,51,90,51,68,100,24,39,11,85,2,22,67,29,74,82,10,96,14,35,25,76,26,54,29,44,63,49,73,50,95,89,43,62,24,88,88,36,6,16,14,2,42,42,60,25,4,58,23,22,27,26,3,79,64,20,92};
        System.out.println(maxNumOfMarkedIndices(nums));
    }
}
