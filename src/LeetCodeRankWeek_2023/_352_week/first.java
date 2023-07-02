package LeetCodeRankWeek_2023._352_week;

// @date 2023/7/2
// @time 10:16
// @author zhangzhi
// @description
public class first {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        int l = 0;
        int r = 0;
        while(l < nums.length){
            for(;l < nums.length; l++){
                if(nums[l] <= threshold && nums[l] % 2 == 0){
                    break;
                }
            }
            r = l;
            while(r < nums.length){
                if(r == l){
                    r++;
                }else if(nums[r] <= threshold && nums[r] % 2 != nums[r - 1] % 2){
                    r++;
                }else{
                    break;
                }
            }
            ans = Math.max(ans, r - l);
            l = r;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,10,3};
        System.out.println(new first().longestAlternatingSubarray(nums, 10));
    }
}
