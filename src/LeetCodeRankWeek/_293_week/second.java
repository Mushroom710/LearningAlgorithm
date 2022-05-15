package LeetCodeRankWeek._293_week;

import java.util.Arrays;

/**
 * @DATE 2022/5/15
 * @TIME 10:46
 * @Created by zhangzhi
 * @description
 */
public class second {

    public static int maxConsecutive(int bottom, int top, int[] special){
        Arrays.sort(special);
        int max = special[0] - bottom;
        top++;
        for (int i = 1;i < special.length;i++){
            max = Math.max(max,special[i] - special[i - 1] - 1);
        }
        max = Math.max(max,top - special[special.length - 1] - 1);
        return max;
    }

    public static void main(String[] args) {
        int[] special = new int[]{7,6,8};
        System.out.println(maxConsecutive(6,8,special));
    }
}
