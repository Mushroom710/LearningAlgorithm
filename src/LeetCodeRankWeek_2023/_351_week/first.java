package LeetCodeRankWeek_2023._351_week;

import java.math.BigInteger;

// @date 2023/6/25
// @time 10:27
// @author zhangzhi
// @description LeetCode 6466. 美丽下标对的数目
public class first {
    private static int gcd(int a, int b) {
        int tmp;
        while (b != 0) {
            if (a < b) {
                tmp = a;
                a = b;
                b = tmp;
            }
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int a = nums[i];
                while(a >= 10){// 取到nums[i]的第一位数
                    a /= 10;
                }
                int b = nums[j] % 10; // 取到nums[j]的最后一位数
                if(gcd(a, b) == 1){
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
