package AutumnPlan_2023.April.day_4_11;

// @date 2023/4/11
// @time 15:01
// @author zhangzhi
// @description LeetCode 18. 四数之和

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            // if(nums[i] > target && nums[i] >= 0){
            //     break;
            // }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    // 如果采用 nums[i] + nums[j] + nums[left] + nums[right] 中方式做加法的话，
                    // 最大的范围就是 int 型的最大值，所以如果连续加很大的数，就会溢出
                    int nb = nums[i] + nums[j];
                    System.out.println("nb : ->" + nb);
                    nb += nums[left];
                    System.out.println("nb + nums[left] :" + nb);
                    nb += nums[right];
                    System.out.println("nb + nums[right] :" + nb);
                    long sum = nums[i] + nums[j];
                    sum += nums[left];
                    sum += nums[right];
                    System.out.println(sum);
                    if(sum > target){
                        right -= 1;
                    }else if(sum < target){
                        left += 1;
                    }else{
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        ans.add(tmp);
                        left += 1;
                        while(left < right && nums[left] == nums[left - 1]){
                            left += 1;
                        }
                        right -= 1;
                        while(left < right && nums[right] == nums[right + 1]){
                            right -= 1;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums, -294967296));
    }
}
