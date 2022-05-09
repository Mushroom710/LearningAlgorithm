package LeetCodeRankWeek._292_week;

/**
 * @DATE 2022/5/8
 * @TIME 11:29
 * @Created by zhangzhi
 * @description 2266 题 统计打字方案数
 * 感觉是一道数学题，但没想到怎么解
 *
 * 2022/5/9 21:28
 * 看了题解，雀食是一道数学题，就是斐波那契的变种题
 * 周赛的时候居然没有想到。。可惜了
 */
public class three {

    public static void calc(int[] nums){
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 4;
        for (int i = 4;i <= 100000;i++){
            nums[i] = nums[i-1] + 3;
        }
    }

    public static int solution(String pressedKeys){
        int[] nums = new int[100001];
        calc(nums);
        int count = 1;
        long ans = 1;
        for (int i = 1;i < pressedKeys.length();){
            if (pressedKeys.charAt(i) == pressedKeys.charAt(i-1)){
                count++;
                i++;
            }else {
                ans *= nums[count];
                count = 1;
                i = i + 1;
            }
        }
        ans *= nums[count];
        double v = (Math.pow(10, 9)) + 7;
        return (int) (ans % v);
    }

    public static void fib(long[] three,long[] four){
        three[0] = 1;
        three[1] = 1;
        three[2] = 2;
        three[3] = 4;
        four[0] = 1;
        four[1] = 1;
        four[2] = 2;
        four[3] = 4;
        for (int i = 4; i <= 100000;i++){
            three[i] = (three[i - 1] + three[i - 2] + three[i - 3]) % 1000000007;
            four[i] = (four[i - 1] + four[i - 2] + four[i - 3] + four[i - 4]) % 1000000007;
        }
    }

    /**
     * @create zhangzhi
     * @date 2022/5/9
     * @time 21:29
     * @description 需要注意到，数字可能非常大，所以计算的地方需要取余
     * 还有，int整数在这里会溢出，所以改用 long 型来保存
     */
    public static int right_solution(String pressedKeys){
        long ans = 1;
        int count = 1;
        long[] three = new long[100001];
        long[] four = new long[100001];
        fib(three,four);
        int i = 1;
        for (; i < pressedKeys.length();i++){
            if (pressedKeys.charAt(i) == pressedKeys.charAt(i - 1)){
                count++;
            }else {
                if (pressedKeys.charAt(i - 1) == '7' || pressedKeys.charAt(i - 1) == '9'){
                    ans = (ans * four[count]) % 1000000007;
                }else {
                    ans = (ans * three[count]) % 1000000007;
                }
                count = 1;
            }
        }
        if (pressedKeys.charAt(i - 1) == '7' || pressedKeys.charAt(i - 1) == '9'){
            ans = (ans * four[count]) % 1000000007;
        }else {
            ans = (ans * three[count]) % 1000000007;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
//        System.out.println(solution("222222222222222222222222222222222222"));
        System.out.println(right_solution("222222222222222222222222222222222222"));
    }
}
