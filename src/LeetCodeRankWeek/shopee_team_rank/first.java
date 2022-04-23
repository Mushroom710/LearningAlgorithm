package LeetCodeRankWeek.shopee_team_rank;

/**
 * @DATE 2022/4/23
 * @TIME 15:08
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static int solution(int[] time, int[][] fruits, int limit){
        int sum = 0;
        for (int i = 0; i < fruits.length;i++){
            if (fruits[i][1] % limit == 0) {
                sum += (fruits[i][1] / limit) * time[fruits[i][0]];
            }else {
                sum += (fruits[i][1] / limit + 1) * time[fruits[i][0]];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] time = new int[]{2,3,2};
        int[][] fruit = new int[][]{{0,2},{1,4},{2,1}};
        System.out.println(solution(time,fruit,3));
    }
}
