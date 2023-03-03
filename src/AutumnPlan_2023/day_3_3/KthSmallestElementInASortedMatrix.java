package AutumnPlan_2023.day_3_3;

// @date 2023/3/3
// @time 20:27
// @author zhangzhi
// @description LeetCode 378. 有序矩阵中第 K 小的元素  二分查找

public class KthSmallestElementInASortedMatrix {

    private static int check(int[][] matrix, int mid, int n){
        int row = n - 1;
        int col = 0;
        int count = 0;
        for(int i = col;i < n;i++){
            for(int j = row; j >= 0; j--){
                if(matrix[j][i] <= mid){
                    count += j + 1;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 看来这个求 mid 的表达式对处理负数很有作用：int mid = l + ((r - l) >> 1);
     * 常规的求 mid 表达式对一些情况不能很好区分开来！案例 [[-5,-4][-5,-4]],k=2。
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while(l < r){
            int mid = l + ((r - l) >> 1);
            int count = check(matrix,mid,n);
            if(count < k){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-5,-4},{-5,-4}};
        System.out.println(kthSmallest(matrix, 2));
    }
}
