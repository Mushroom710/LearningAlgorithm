package AutumnPlan_2023.June.day_6_12;

// @date 2023/6/12
// @time 10:10
// @author zhangzhi
// @description LeetCode 167. 两数之和 II - 输入有序数组
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right  = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                break;
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}
