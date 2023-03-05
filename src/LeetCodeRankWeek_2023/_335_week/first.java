package LeetCodeRankWeek_2023._335_week;

// @date 2023/3/5
// @time 10:26
// @author zhangzhi
// @description

public class first {

    public static int passThePillow(int n, int time) {
        int len = 2 * n - 2;
        int div = time % len;
        if(div <= n - 1){
            return div + 1;
        }
        return 2 * n - div - 1;
    }

    public static void main(String[] args) {
        System.out.println(passThePillow(3,2));
    }
}
