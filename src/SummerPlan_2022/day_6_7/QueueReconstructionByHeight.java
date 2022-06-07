package SummerPlan_2022.day_6_7;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @DATE 2022/6/7
 * @TIME 18:50
 * @Created by zhangzhi
 * @description LeetCode 406 题 根据身高重建队列
 * 关于出现两个维度一起考虑的情况
 * 其技巧都是确定一边然后贪心另一边，两边一起考虑，就会顾此失彼。
 */
public class QueueReconstructionByHeight {

    /**
     * @create zhangzhi
     * @date 2022/6/7
     * @time 19:05
     * @description
     * Arrays.sort 的一些进阶用法
     * //以每行为单位，按照每一行第一个元素为单位，进行升序列排列
     * Arrays.sort(arr,(a,b)->a[0]-b[0]);
     * //以每行为单位，按照每一行第一个元素为单位，进行降序列排列
     * Arrays.sort(arr,(a,b)->b[0]-a[0]);
     *
     * //以每行为单位，按照每一行第二个元素为单位，进行升序列排列
     * Arrays.sort(arr,(a,b)->a[1]-b[1]);
     * //以每行为单位，按照每一行第二个元素为单位，进行降序列排列
     * Arrays.sort(arr,(a,b)->b[1]-a[1]);
     *
     * //以每行为单位，按照每一行第三个元素为单位，进行升序列排列
     * Arrays.sort(arr,(a,b)->a[2]-b[2]);
     * //以每行为单位，按照每一行第三个元素为单位，进行降序列排列
     * Arrays.sort(arr,(a,b)->b[2]-a[2]);
     */
    public static int[][] reconstructQueue(int[][] people) {
        // 还可以写 if 语句
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];//身高相同，k 小的在前面
            return b[0] - a[0];// 否则从大到小排
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people){
            que.add(p[1],p);
        }
        return que.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0},{4,1}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    };
}
