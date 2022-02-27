package LeetCodeRankWeek.week;

/**
 * @DATE 2022/2/26
 * @Created by zhangzhi
 */
public class first {

    public static int solution(int num){
        int count = 0;
        int sum = 0;
        for(int i=1;i<=num;i++){
            int temp = i;
            while(temp>0){
                sum += temp%10;
                temp /= 10;
            }
            if(sum%2==0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(1000));
    }
}
