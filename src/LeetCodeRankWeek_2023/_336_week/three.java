package LeetCodeRankWeek_2023._336_week;

// @date 2023/3/12
// @time 10:59
// @author zhangzhi
// @description

import java.util.HashMap;
import java.util.Map;

public class three {

    // 想到了异或，但是超时了
    public static long beautifulSubarrays(int[] nums) {
        long total = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            long num = 0;
            for(int j = i; j < len; j++) {
                num = num ^ nums[j];
                if (num == 0) {
                    total++;
                }
            }
        }
        return total;
    }

    // 想到了 前缀和 ，后序就不知道怎么做了
    public static long solution(int[] nums){
        int n = nums.length;
        long[] prefix = new long[n];
        long total = 0;
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] ^ nums[i];
            if(prefix[i] == 0){
                total++;
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = i; j < n; j++){
                prefix[j] = prefix[j] ^ nums[i];
                if(prefix[j] == 0){
                    total++;
                }
            }
        }
        return total;
    }

    // 前缀和定义为 左闭右开区间
    public static long solution2(int[] nums){
        int len = nums.length;
        int[] prefix = new int[len + 1];
        // 前缀和需要补一个 0
        prefix[0] = 0;
        for(int i = 0; i < len; i++){
            prefix[i + 1] = prefix[i] ^ nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        // 统计前缀和中数对的个数
        for(int i = 0; i <= len; i++){
            ans += map.getOrDefault(prefix[i], 0);
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        System.out.println(solution2(nums));
    }
}
