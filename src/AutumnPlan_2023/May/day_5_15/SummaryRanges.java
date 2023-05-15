package AutumnPlan_2023.May.day_5_15;

import java.util.ArrayList;
import java.util.List;

// @date 2023/5/15
// @time 22:15
// @author zhangzhi
// @description
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int start = nums[0];
        int end = nums[0];
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(end == nums[i]){
                end++;
            }else{
                String s = start + "->" + (end - 1);
                ans.add(s);
                start = nums[i];
                end = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(new SummaryRanges().summaryRanges(nums).toString());
    }
}
