package LeetCodeRankWeek_2023._341_week;

// @date 2023/4/16
// @time 10:21
// @author zhangzhi
// @description
public class first {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int idx = 0;
        int max = 0;
        for(int i = 0; i < mat.length; i++){
            int[] nums = mat[i];
            int count = 0;
            for(int num : nums){
                if(num == 1){
                    count++;
                }
            }
            if(count > max){
                max = count;
                idx = i;
            }
        }
        return new int[]{idx, max};
    }
}
