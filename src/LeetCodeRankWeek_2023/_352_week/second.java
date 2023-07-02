package LeetCodeRankWeek_2023._352_week;

import java.util.*;

// @date 2023/7/2
// @time 10:16
// @author zhangzhi
// @description
// 首先预处理出在 10^6 范围内的所有质数，放进 set 中，查询时间复杂度为 O(1)
// 二分还是慢一些。
public class second {
    static Set<Integer> prime = new HashSet<>();

    static{
        for(int i = 1; i <= 1000000; i++){
            if(isPrime(i)){
                prime.add(i);
            }
        }
    }

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
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] flag = new boolean[n + 1];
        for(int i = 2; i <= n; i++){
            if(!flag[i] && !flag[n - i] && prime.contains(i) && prime.contains(n - i)){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(n - i);
                flag[i] = true;
                flag[n - i] = true;
                ans.add(tmp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new second().findPrimePairs(10).toString());
    }
}
