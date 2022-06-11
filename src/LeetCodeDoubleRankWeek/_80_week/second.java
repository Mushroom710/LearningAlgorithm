package LeetCodeDoubleRankWeek._80_week;

import java.util.Arrays;

/**
 * @DATE 2022/6/11
 * @TIME 22:48
 * @Created by zhangzhi
 * @description
 */
public class second {

    private static int bianry(long success,int num,int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if ((long) num * nums[mid] >= success){
                return mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

//    for (int j = 0;j < potions.length;j++){
//                if ((long) spells[i] * potions[j] >= success){
//                    idx = j;
//                    ans[k] = potions.length - j;
//                    k++;
//                    break;
//                }
//            }
//            if (idx == 0 && k == i) {
//                ans[k] = 0;
//                k++;
//            }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        Arrays.sort(spells);
        Arrays.sort(potions);
        int k = 0;
        int[] ans = new int[spells.length];
        for (int i = 0;i < spells.length;i++){
            int idx = 0;
            for (int j = potions.length - 1; j >= 0;j--){
                if ((long) spells[i] * potions[j] < success){
                    idx = j;
                    break;
                }
            }
            if (idx <= 0){
                if (k == i){
                    ans[i] = 0;
                }else {
                    ans[i] = potions.length - idx;
                }
            }else {
                ans[i] = potions.length - idx;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] spell = new int[]{34,25,34,20,5,11,8};
        int[] point = new int[]{6,11};
        System.out.println(Arrays.toString(successfulPairs(spell,point,98)));
    }
}
