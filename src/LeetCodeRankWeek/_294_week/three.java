package LeetCodeRankWeek._294_week;

import java.util.Arrays;

/**
 * @DATE 2022/5/22
 * @TIME 10:58
 * @Created by zhangzhi
 * @description
 */
public class three {

    public static int[][] mySort(int[][] array){
        Arrays.sort(array, (arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr1[0] - arr2[0]);//lambda：Arrays.sort(matrix, (a, b) -> a[0] - b[0]);
        return array;
    }

    public static int minimumLines(int[][] stockPrices){
        if (stockPrices.length < 2)return 0;
        int count = 0;
        mySort(stockPrices);
        for (int[] arr : stockPrices){
            System.out.println(Arrays.toString(arr));
        }
        //int k = (stockPrices[0][1] - stockPrices[1][1]) / (stockPrices[0][0] - stockPrices[1][0]);
        //int b = stockPrices[0][1] - (k * stockPrices[0][0]);
//        for (int i = 2;i < stockPrices.length;i++){
//            if (stockPrices[i][1] != stockPrices[i][0] * (stockPrices[i][1] - stockPrices[i-1][1]) / (stockPrices[i][0] - stockPrices[i-1][0])  + b){
//                count++;
//                //b = stockPrices[i][1] - (k * stockPrices[i][0]);
//            }
//        }
        int px = stockPrices[0][0];
        int py = stockPrices[0][1];
        int kx = stockPrices[1][0] - px;
        int ky = stockPrices[1][1] - py;
        for (int i = 1; i < stockPrices.length;i++){
            if (ky * (stockPrices[i][0] - px) != kx * (stockPrices[i][1] - py)){
                count++;
                px = stockPrices[i - 1][0];
                py = stockPrices[i - 1][1];
                kx = stockPrices[i][0] - px;
                ky = stockPrices[i][1] - py;
            }
        }
        return count + 1;
    }
    // [[83,35],[79,51],[61,48],[54,87],[44,93],[22,5],[87,28],[64,8],[89,78],[62,83],[58,72],[48,7],[97,16],[27,100],[65,48],[11,31],[29,76],[93,29],[72,59],[73,74],[9,90],[66,81],[12,8],[86,80],[84,43],[36,63],[80,45],[81,88],[95,5],[40,59]]
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,7},{2,6},{3,5},{4,4},{5,4},{6,3},{7,2},{8,1}};
        System.out.println(minimumLines(nums));
    }
}
