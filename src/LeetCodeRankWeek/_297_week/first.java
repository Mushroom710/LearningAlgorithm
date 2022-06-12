package LeetCodeRankWeek._297_week;

/**
 * @DATE 2022/6/12
 * @TIME 10:17
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static double calculateTax(int[][] brackets, int income) {
        double sum = 0;
        if (income > brackets[0][0]){
            sum += (1.0 * brackets[0][0] * brackets[0][1]) / 100;
        }else{
            sum += (1.0 * income * brackets[0][1]) / 100;
            return sum;
        }
        for (int i = 1; i < brackets.length;i++){
            if (income > brackets[i][0]){
                sum += 1.0 * (brackets[i][0] - brackets[i - 1][0]) * brackets[i][1] / 100;
            }else{
                sum += 1.0 * (income - brackets[i - 1][0]) * brackets[i][1] / 100;
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{10,10}};
        System.out.println(calculateTax(nums,5));
    }
}
