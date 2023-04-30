package AutumnPlan_2023.April.day_4_30;

// @date 2023/4/30
// @time 21:50
// @author zhangzhi
// @description LeetCode 1052. 爱生气的书店老板
public class GrumpyBookstoreOwner {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ok = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                ok += customers[i];
            }
        }
        int max = ok;
        for(int i = 0; i <= customers.length - minutes; i++){
            int tmp = ok;
            for(int j = i; j < i + minutes; j++){
                if(grumpy[j] == 1){
                    tmp += customers[j];
                }
            }
            max = Math.max(max, tmp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] customers = new int[]{8, 8};
        int[] grumpy = new int[]{1, 0};
        System.out.println(maxSatisfied(customers, grumpy, 2));
    }
}
