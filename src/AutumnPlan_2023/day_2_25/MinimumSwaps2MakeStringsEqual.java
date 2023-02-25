package AutumnPlan_2023.day_2_25;

// @date 2023/2/25
// @time 21:12
// @author zhangzhi
// @description LeetCode 1247. 交换字符使得字符串相同
// 贪心法
// s1[i]和s2[i]不同无非是这两种情况：
//      (1)s1[i] = x
//          s2[i] = y
//      (2)s1[i] = y
//          s2[i] = x
//      记录（1）（2）两种情况的个数分别为 m、n。
//      当 n, m为奇数; count = n / 2 + m / 2 + 2。
//      当 n, m为偶数; count = n / 2 + m / 2。


/**
 * @author zhangzhi
 */
public class MinimumSwaps2MakeStringsEqual {

    public static int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                if(s1.charAt(i) == 'x'){
                    xy++;
                }else {
                    yx++;
                }
            }
        }
        if((xy + yx) % 2 != 0){
            return -1;
        }
        return xy % 2 == 1 ? (xy / 2 + yx / 2 + 2) : (xy / 2 + yx / 2);
    }

    public static void main(String[] args) {
        String s1 = "xx";
        String s2 = "yy";
        System.out.println(minimumSwap(s1,s2));
    }
}
