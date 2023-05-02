package AutumnPlan_2023.May.day_5_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @date 2023/5/2
// @time 21:33
// @author zhangzhi
// @description 每日一题 LeetCode 970. 强整数
public class PowerfulIntegers {

    // 1不管怎么算，都是1。所以要找第二小的，2，log_2(10^6)大概是21，所以枚举到21就可以囊括所有情况。
    // log_2(10^6) 这个怎么估计嘞？要知道 2^32 大概是 42亿，用这个做参考就行。
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= 21; i++){
            long n = (long)Math.pow(x, i);
            if(n > bound){
                break;
            }
            for(int j = 0; j <= 21; j++){
                long num = n + (long)Math.pow(y, j);
                if(num > bound){
                    break;
                }
                if(!set.contains((int)num)){
                    list.add((int)num);
                    set.add((int)num);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PowerfulIntegers().powerfulIntegers(1, 1, 400000));
    }
}
