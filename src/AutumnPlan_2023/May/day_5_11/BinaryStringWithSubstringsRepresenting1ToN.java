package AutumnPlan_2023.May.day_5_11;

// @date 2023/5/11
// @time 22:13
// @author zhangzhi
// @description 每日一题 LeetCode 1016. 子串能表示从 1 到 N 数字的二进制串
public class BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String s, int n) {
        for(int i = 1; i <= n; i++){
            String b = Integer.toBinaryString(i);
            if(!s.contains(b)){
                return false;
            }
        }
        return true;
    }
}
