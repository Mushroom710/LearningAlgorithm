package LeetCodeRankWeek._322_week;

// @date 2022/12/4
// @time 11:35
// @author zhangzhi
// @description

import java.util.Arrays;
import java.util.Comparator;

public class three {

    private static int find(int[][] roads){

    }

    public static int minScore(int n, int[][] roads) {
        Arrays.sort(roads, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] == o2[2]) {
                    return o1[0] - o2[0];
                }
                return o1[2] - o2[2];
            }
        });

        for(int[] nums : roads) {
            System.out.println(Arrays.toString(nums));
        }

        for(int i = 0; i < roads.length; i++) {

        }
    }

    public static void main(String[] args) {
        int[][] roads = new int[][]{{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        minScore(4, roads);
    }
}
