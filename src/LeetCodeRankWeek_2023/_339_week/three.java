package LeetCodeRankWeek_2023._339_week;

// @date 2023/4/2
// @time 11:20
// @author zhangzhi
// @description


import java.util.Arrays;
import java.util.Comparator;

public class three {

    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int len = reward1.length;
        int[][] diff = new int[len][2];
        //boolean[] flag = new boolean[len];
        for(int i = 0; i < len; i++){
            diff[i][0] = reward1[i] - reward2[i];
            diff[i][1] = i;
        }
        Arrays.sort(diff, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        int sum = 0;
        for(int i = 0; i < k; i++){
            int tmp = reward1[diff[i][1]];
            sum = sum + tmp;
        }
        for(int i = k; i < len; i++){
            sum = sum + reward2[diff[i][1]];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] reward1 = new int[]{1,1,3,4};
        int[] reward2 = new int[]{4,4,1,1};
        System.out.println(miceAndCheese(reward1, reward2, 2));
    }
}
