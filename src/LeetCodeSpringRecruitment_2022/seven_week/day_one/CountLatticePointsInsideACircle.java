package LeetCodeSpringRecruitment_2022.seven_week.day_one;

/**
 * @DATE 2022/4/25
 * @TIME 21:27
 * @Created by zhangzhi
 * @description LeetCode 2249 题  统计圆内格点数目
 * 做题的时候一定要看好提示！！！
 * 提示一就说明了这个圈是有最大的半径，直接遍历即可
 *      1 <= circles.length <= 200
 *      circles[i].length == 3
 *      1 <= xi, yi <= 100
 *      1 <= ri <= min(xi, yi)
 */
public class CountLatticePointsInsideACircle {

    /**
     * @create zhangzhi
     * @date 2022/4/25
     * @time 21:57
     * @description 使用数组去重，寄了，周赛的时候居然没想到
     */
    public static int solution(int[][] circles){
        boolean[][] flag = new boolean[201][201];
        for (int i = 0;i <= 200;i++){
            for (int j = 0;j<=200;j++){
                for (int[]circle : circles){
                    int x = circle[0];
                    int y = circle[1];
                    int r = circle[2];
                    if (!flag[i][j]&&((x - i) * (x - i) + (y - j) * (y - j)) <= r * r) {
                        flag[i][j] = true;
                        break;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0;i<=200;i++){
            for (int j = 0;j<=200;j++){
                if (flag[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * @create zhangzhi
     * @date 2022/4/25
     * @time 21:57
     * @description 当咯，也是可以不用数组去重的
     */
    public static int solution_two(int[][] circles){
        int ans = 0;
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                for (int[] circle : circles) {
                    int x = circle[0], y = circle[1], r = circle[2];
                    if ((i - x) * (i - x) + (j - y) * (j - y) <= r * r) {
                        ++ans;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2,2,2},{3,4,1}}));
        System.out.println(solution_two(new int[][]{{2,2,2},{3,4,1}}));
    }
}
