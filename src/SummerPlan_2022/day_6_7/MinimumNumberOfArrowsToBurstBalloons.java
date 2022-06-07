package SummerPlan_2022.day_6_7;

import java.util.Arrays;

/**
 * @DATE 2022/6/7
 * @TIME 19:29
 * @Created by zhangzhi
 * @description LeetCode 452 题 用最少数量的箭引爆气球
 * 转化
 * 如果真实的模拟射气球的过程，应该射一个，气球数组就 remove 一个元素，这样最直观，毕竟气球被射了。
 * 但仔细思考一下就发现：如果把气球排序之后，从前到后遍历气球，被射过的气球仅仅跳过就行了，
 * 没有必要让气球数组 remove 气球，只要记录一下箭的数量就可以了。
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0)return 0;
        // 用 Integer 是可以应对一些极端数据的情况，比如：2^32 之类的
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int count = 1;
        for (int i = 1;i < points.length;i++){
            if (points[i][0] > points[i - 1][1]){
                count++;
            }else {
                points[i][1] = Math.min(points[i - 1][1],points[i][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{10,6},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));
    }
}
