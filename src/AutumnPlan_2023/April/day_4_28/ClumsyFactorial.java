package AutumnPlan_2023.April.day_4_28;

// @date 2023/4/28
// @time 21:51
// @author zhangzhi
// @description LeetCode 1006. 笨阶乘
public class ClumsyFactorial {

    public int clumsy(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 6;
        } else if (n == 4) {
            return 7;
        }

        if (n % 4 == 0) {
            return n + 1;
        } else if (n % 4 <= 2) {
            return n + 2;
        } else {
            return n - 1;
        }
    }
}
