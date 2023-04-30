package LeetCodeRankWeek_2023._343_week;

import java.util.HashMap;

// @date 2023/4/30
// @time 10:23
// @author zhangzhi
// @description
public class second {

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] idxs = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++){
            idxs[arr[i]] = i;
        }
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i = 0; i < arr.length; i++){
            int[] matIdx = map.get(arr[i]);
            row[matIdx[0]]++;
            col[matIdx[1]]++;
//            if(row[matIdx[0]] == n){
//                for(int j = 0; j < n; j++){
//                    if(col[j] - 1 == matIdx[0]){
//                        return idxs[mat[matIdx[0]][j]];
//                    }
//                }
//            }
//            if(col[matIdx[1]] == m){
//                for(int j = 0; j < m; j++){
//                    if(row[j] - 1 == matIdx[1]){
//                        return idxs[mat[j][matIdx[1]]];
//                    }
//                }
//            }
            // 只需要有一列或在一行被涂满就可以直接返回
            // 我还以为是找出行列的交叉位置的下标。。。。。
            if(row[matIdx[0]] == n || col[matIdx[1]] == n){
                return i;
            }
        }
        return mat[0][0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,7,4,1,3,5,6,9};
        int[][] mat = new int[][]{{3,2,5},{1,4,6},{8,7,9}};
        System.out.println(firstCompleteIndex(arr, mat));
    }
}
