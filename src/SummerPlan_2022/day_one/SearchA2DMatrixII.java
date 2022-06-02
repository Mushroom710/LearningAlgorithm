package SummerPlan_2022.day_one;

import javax.swing.plaf.ProgressBarUI;

/**
 * @DATE 2022/6/2
 * @TIME 23:42
 * @Created by zhangzhi
 * @description LeetCode 240 题 搜索二维矩阵 II
 *  1.每行的所有元素从左到右升序排列
 *  2.每列的所有元素从上到下升序排列
 *  这个序列从右上角看会是一颗二叉搜索树，神奇！！！
 *  善于观察，也许就能想到一个奇妙的解法！
 */
public class SearchA2DMatrixII {

    /**
     * @create zhangzhi
     * @date 2022/6/3
     * @time 0:35
     * @description 暴力解法
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[0].length;j++){
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @create zhangzhi
     * @date 2022/6/3
     * @time 0:35
     * @description 尝试使用二分查找法，过了 118个用例
     */
    public static boolean searchMatrix_two(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length;i++){
            if (matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target){
                int y = binarySearch_x(matrix,target,i);
                if (y == target){
                    return true;
                }
                int x = binarySearch_y(matrix,target,y);
                if (x == target){
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static int binarySearch_x(int[][] matrix,int target,int idx){
        int left = 0;
        int right = matrix[0].length;
        int mid = 0;
        while (left <= right){
            mid = (right + left) / 2;
            if (matrix[idx][mid] == target){
                return target;
            }else if (matrix[idx][mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return mid;
    }
    public static int binarySearch_y(int[][] matrix,int target,int idx){
        int left = 0;
        int right = matrix.length;
        int mid = 0;
        while (left <= right && left < matrix.length && right < matrix[0].length){
            mid = (right + left) / 2;
            if (matrix[mid][idx] == target){
                return target;
            }else if (matrix[mid][idx] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return mid;
    }

    /**
     * @create zhangzhi
     * @date 2022/6/3
     * @time 0:32
     * @description 评论区真是神奇的地方。从右上角看还真是一个二叉搜索树
     */
    public static boolean solution_one(int[][] matrix, int target){
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] > target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][] nums = new int[][]{{-1,3}};
        System.out.println(solution_one(nums,5));
    }
}
