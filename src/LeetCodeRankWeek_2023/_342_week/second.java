package LeetCodeRankWeek_2023._342_week;

// @date 2023/4/23
// @time 10:13
// @author zhangzhi
// @description
public class second {

    public int sumOfMultiples(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 || i % 5 == 0 || i % 7 == 0){
                sum += i;
            }
        }
        return sum;
    }
}
