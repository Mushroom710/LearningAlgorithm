package AutumnPlan_2022.day_10_21;

// @date 2022/10/21
// @time 15:57
// @author zhangzhi
// @description

public class RemoveStonesToMinimizeTheTotal {

    public static int minStoneSum(int[] piles, int k) {
        for(int i = 0;i < k; i++){
            int tmp_max = -1;
            int idx = 0;
            for(int j = 0;j < piles.length; j++){
                if(tmp_max < piles[j]){
                    tmp_max = piles[j];
                    idx = j;
                }
            }
            piles[idx] = (int) Math.ceil(tmp_max / 2.0);
        }
        int sum = 0;
        for(int num : piles){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,6,7};
        System.out.println(minStoneSum(nums,3));
    }
}
