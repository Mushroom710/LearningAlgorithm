package AutumnPlan_2023.March.day_3_19;

// @date 2023/3/19
// @time 21:28
// @author zhangzhi
// @description LeetCode 202. 快乐数

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    private static long squareEach(long n){
        long sum = 0;
        while(n != 0){
            long pos = n % 10;
            sum += pos * pos;
            n /= 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        Set<Long> set = new HashSet<>();
        long num = n;
        while(num != 1){
            System.out.println(num);
            if(!set.add(num)){
                return false;
            }
            num = squareEach(num);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
