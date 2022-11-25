package AutumnPlan_2022.day_11_25;

// @date 2022/11/25
// @time 21:49
// @author zhangzhi
// @description LeetCode 202 题 快乐数

import java.util.HashSet;
import java.util.Set;

public class HappyNumber{

    private static long square(long n){
        long ans = 0;
        while(n != 0){
            long num = n % 10;
            ans += num * num;
            n = n / 10;
        }
        return ans;
    }

    /**
     * 题目里提示了会可能会出现无限循环，那么，在这个循环里，一定会出现之前计算过的值。如果出现，就说明这个数不是快乐数！
     * 还有，注意整数溢出的错误！
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        Set<Long> set = new HashSet<>();
        long num = n;
        while(true){
            num = square(num);
            if(num == 1){
                return true;
            }else if(!set.add(num)){
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
