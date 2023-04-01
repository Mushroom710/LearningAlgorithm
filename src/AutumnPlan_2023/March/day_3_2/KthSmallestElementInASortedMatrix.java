package AutumnPlan_2023.March.day_3_2;

// @date 2023/3/2
// @time 21:51
// @author zhangzhi
// @description LeetCode 378. 有序矩阵中第 K 小的元素
// 二分查找

public class KthSmallestElementInASortedMatrix {

    private static int count(int[][] matrix, int mid) {
        int n = matrix[0].length;
        int row = n - 1;
        int col = 0;
        int count = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
                //row = n - 1;
            } else {
                row--;
            }
        }
        return count;
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length - 1;
        int left = matrix[0][0];
        int right = matrix[n][n];
        while (left < right) {
            int mid = (left + right) / 2;
            int tmp = count(matrix, mid);
            if (tmp < mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

}
