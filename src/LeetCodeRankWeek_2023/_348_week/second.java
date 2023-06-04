package LeetCodeRankWeek_2023._348_week;

// @date 2023/6/4
// @time 10:27
// @author zhangzhi
// @description
public class second {

    public int semiOrderedPermutation(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                start = i;
            }
            if(nums[i] == nums.length){
                end = i;
            }
        }
        if(start == 0 && end == nums.length - 1){
            return 0;
        }else if(start == 0){
            return nums.length - end - 1;
        }else if(end == nums.length - 1) {
            return start;
        }else if(start < end){
            return start + nums.length - end - 1;
        }
        return start + nums.length - end - 2;
    }
}
