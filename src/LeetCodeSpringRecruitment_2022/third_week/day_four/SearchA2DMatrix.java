package LeetCodeSpringRecruitment_2022.third_week.day_four;

/**
 * @DATE 2022/3/31
 * @TIME 15:13
 * @Created by zhangzhi
 * @description LeetCode 74 题 搜索二维矩阵
 */
public class SearchA2DMatrix {

    /**
     * @create zhangzhi
     * @date 2022/3/31
     * @time 15:30
     * @description 二分法
     * 1.先找到 target 可能在哪一层
     * 2.在可能的那一层里进行二分查找
     */
    public static boolean solution(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int ceng = 0;
        for(;ceng < m;ceng++){
            if(target >= matrix[ceng][0] && target <= matrix[ceng][n-1]) {
                break;
            }
        }
        // 这里考虑疏忽了一点
        // 边界条件稍微考虑少了些。如果找到了在哪一层，
        // 那么一定有ceng<m,否则ceng==m，这时就说明，没有一层是可能存在target的。
        if(ceng == m){
            return false;
        }
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[ceng][mid] == target){
                return true;
            }else if(matrix[ceng][mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = new int[][]{{1}};
        System.out.println(solution(matrix,1));

    }
}
