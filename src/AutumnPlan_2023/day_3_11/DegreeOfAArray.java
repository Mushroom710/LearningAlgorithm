package AutumnPlan_2023.day_3_11;

// @date 2023/3/11
// @time 20:55
// @author zhangzhi
// @description LeetCode 697. 数组的度

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAArray {
    /**
     * 用数组保存数字出现的次数，第一次出现的位置，最后一次出现的位置
     * @param nums
     * @return
     */
    public static int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else{
                map.put(nums[i], new int[]{1,i,i});
            }
        }
        int max = 0;
        int minLen = 0;
        // 这个遍历方式非常巧妙，可以在一次遍历中得出 最大度 和 最短连续数组长度
        for(Map.Entry<Integer, int[]> entry : map.entrySet()){
            int[] tmp = entry.getValue();
            if(max < tmp[0]){ // 先计算 最大度
                max = tmp[0];
                minLen = tmp[2] - tmp[1] + 1;
            }else if(max == tmp[0]){// 这个时候说明有相同的度出现，重新计算最短连续数组的长度
                if(minLen > tmp[2] - tmp[1] + 1){
                    minLen = tmp[2] - tmp[1] + 1;
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,1};
        System.out.println(findShortestSubArray(nums));
    }
}
