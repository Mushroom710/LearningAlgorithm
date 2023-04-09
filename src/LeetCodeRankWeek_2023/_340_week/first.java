package LeetCodeRankWeek_2023._340_week;

// @date 2023/4/9
// @time 10:23
// @author zhangzhi
// @description

public class first {

    /**
     * 判定质数的模板方法
     */
    private static boolean isPrime(int num){
        int i = 2;
        while(i * i <= num){
            if(num % i == 0){
                return false;
            }
            i += 1;
        }
        return num >= 2;
    }
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i][i] > ans && isPrime(nums[i][i])){
                ans = Math.max(ans, nums[i][i]);
            }
            if(nums[i][n - i - 1] > ans && isPrime(nums[i][n - i - 1])){
                ans = Math.max(ans, nums[i][n - i - 1]);
            }
        }
        return ans;
    }
}
