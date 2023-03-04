package AutumnPlan_2023.day_3_4;

// @date 2023/3/4
// @time 21:56
// @author zhangzhi
// @description LeetCode 400. 第 N 位数字

public class NthDigit {

    private static int calc(int n){
        int digit = 9;
        int i = 2;
        while(digit < n){
            digit += i * 9 * Math.pow(10, i - 1);
            i++;
        }
        return i;
    }

    public static int findNthDigit(int n) {
        if(n <= 9){
            return n;
        }
        int digit = 9;
        int i = 2;
        while(digit < n){
            digit += i * 9 * Math.pow(10, i - 1);
            i++;
        }
        int tmp = (int) (digit - (i - 2) * 9 * Math.pow(10, i - 3));
        digit -= tmp;
        int odd = n - digit;
        int start = (int) Math.pow(10, i);
        int chushu = odd / i;
        int qiuyu = odd % i;
        String s = String.valueOf(start + chushu);
        if(qiuyu == 0){
            return s.charAt(s.length() - 1);
        }
        return s.charAt(qiuyu);
    }

    /**
     * 正确解答
     * @param n
     * @return
     */
    public int findNthDigit2(int n) {
        int len = 1;
        while (len * 9 * Math.pow(10, len - 1) < n) {
            n -= len * 9 * Math.pow(10, len - 1);
            len++;
        }
        long s = (long) Math.pow(10, len - 1);
        long x = n / len - 1 + s;
        n -= (x - s + 1) * len;
        return n == 0 ? (int) (x % 10) : (int) ((x + 1) / Math.pow(10, len - n) % 10);
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(490));
    }
}
