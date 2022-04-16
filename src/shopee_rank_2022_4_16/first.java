package shopee_rank_2022_4_16;

import java.util.Arrays;

/**
 * @DATE 2022/4/16
 * @TIME 15:07
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static int solution(int[] gem, int[][] operations){
        for (int i = 0;i < operations.length; i++){
            int tmp = (int) Math.floor(gem[operations[i][0]] / 2.0);
            gem[operations[i][1]] += tmp;
            gem[operations[i][0]] -= tmp;
        }
        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }

    public static void main(String[] args) {

    }
}
