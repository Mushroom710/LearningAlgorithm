package SummerPlan_2022.day_6_7;

/**
 * @DATE 2022/6/7
 * @TIME 18:32
 * @Created by zhangzhi
 * @description LeetCode 860 题 柠檬水找零
 * 有如下三种情况：
 * 情况一：账单是 5，直接收下。
 * 情况二：账单是 10，消耗一个 5，增加一个 10
 * 情况三：账单是 20，优先消耗一个 10和一个 5，如果不够，再消耗三个 5
 * 账单是 20的情况，为什么要优先消耗一个 10和一个 5 呢？
 * 因为美元 10 只能给账单 20 找零，而美元 5 可以给账单 10 和账单 20 找零，美元 5更万能！
 * 所以局部最优：遇到账单 20，优先消耗美元 10，完成本次找零。
 * 全局最优：完成全部账单的找零。
 */
public class LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
//        int twenty = 0;
        for (int i = 0;i < bills.length;i++){
            if (bills[i] == 5){
                five++;
            }else if (bills[i] == 10){
                ten++;
                if (five >= 1){
                    five--;
                }else {
                    return false;
                }
            }else {
//                twenty++;
                if (five>=1 && ten >= 1){
                    five--;
                    ten--;
                }else if (five >= 3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = new int[]{5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
}
