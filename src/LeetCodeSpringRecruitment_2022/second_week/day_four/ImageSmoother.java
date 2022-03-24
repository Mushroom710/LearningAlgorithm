package LeetCodeSpringRecruitment_2022.second_week.day_four;

import java.util.Arrays;

/**
 * @DATE 2022/3/24
 * @TIME 15:00
 * @Created by zhangzhi
 * @description
 */
public class ImageSmoother {

    /**
     * @create zhangzhi
     * @date 2022/3/24
     * @time 21:35
     * @description 考虑的肤浅了
     * 其实只需要统计 img[i][j] 附近是否有格子即可，然后累加求平均值
     */
    public static int[][] solution(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        if(m < 2){
            return img;
        }
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i - 1) < 0 && (j - 1 < 0)) {
                    result[i][j] = (int) Math.floor((img[i][j] + img[i + 1][j] + img[i][j + 1] + img[i + 1][j + 1]) / 4.0);
                } else if ((i - 1 < 0) && (j + 1 >= n)) {
                    result[i][j] = (int) Math.floor((img[i][j] + img[i + 1][j] + img[i][j - 1] + img[i + 1][j - 1]) / 4.0);
                } else if ((i + 1 >= m) && (j - 1 < 0)) {
                    result[i][j] = (int) Math.floor((img[i][j] + img[i - 1][j] + img[i - 1][j + 1] + img[i][j + 1]) / 4.0);
                } else if ((i + 1 >= m) && (j + 1 >= n)) {
                    result[i][j] = (int) Math.floor((img[i][j] + img[i][j - 1] + img[i][j - 1] + img[i - 1][j - 1]) / 4.0);
                } else if (i - 1 < 0) {
                    result[i][j] = (int) Math.floor((img[i][j - 1] + img[i][j] + img[i][j + 1] + img[i + 1][j - 1] + img[i + 1][j] + img[i + 1][j + 1]) / 6.0);
                } else if (j - 1 < 0) {
                    result[i][j] = (int) Math.floor((img[i - 1][j] + img[i][j] + img[i + 1][j] + img[i - 1][j + 1] + img[i][j + 1] + img[i + 1][j + 1]) / 6.0);
                } else if (j + 1 >= n) {
                    result[i][j] = (int) Math.floor((img[i - 1][j] + img[i][j] + img[i + 1][j] + img[i - 1][j - 1] + img[i][j - 1] + img[i + 1][j - 1]) / 6.0);
                } else if (i + 1 >= m) {
                    result[i][j] = (int) Math.floor((img[i][j - 1] + img[i][j] + img[i][j + 1] + img[i - 1][j - 1] + img[i - 1][j] + img[i - 1][j + 1]) / 6.0);
                } else {
                    result[i][j] = (int) Math.floor((img[i - 1][j - 1] + img[i - 1][j] + img[i - 1][j + 1] + img[i][j - 1] + img[i][j] + img[i][j + 1] + img[i + 1][j - 1] + img[i + 1][j] + img[i + 1][j + 1]) / 9.0);
                }
            }
        }
        return result;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/24
     * @time 21:41
     * @description 直接统计 img[i][j] 附近的所有格子即可。然后累加求平均值。
     * 这种算法可以应对更加一般的情况
     */
    public static int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0, sum = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            num++;
                            sum += img[x][y];
                        }
                    }
                }
                ret[i][j] = sum / num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] img = new int[][]{
                {100, 200, 100},
                {200, 50, 200},
                {100, 200, 100},
        };
        for (int[] arr : solution(img)) {
            System.out.println(Arrays.toString(arr));
        }
        for(int[] arr : imageSmoother(img)){
            System.out.println(Arrays.toString(arr));
        }
    }
}
