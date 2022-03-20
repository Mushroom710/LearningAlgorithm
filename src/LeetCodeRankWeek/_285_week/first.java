package LeetCodeRankWeek._285_week;

/**
 * @DATE 2022/3/20
 * @TIME 10:25
 * @Created by zhangzhi
 */
public class first {

    public static int solution(int[] nums){
        int count = 0;
        for(int left = 0 ; left < nums.length -2;){
            if(nums[left + 1] > nums[left] || nums[left + 1] < nums[left]) {
                for (int right = left + 1; right < nums.length - 1; ) {
                    if (nums[right] > nums[left] && nums[right + 1] < nums[right]) {
                        count++;
                        left = right;
                        break;
                    }else if(nums[right] < nums[left] && nums[right + 1] > nums[right]){
                        count++;
                        left = right;
                        break;
                    }else if(nums[right] == nums[right + 1]){
                        while (nums[right] == nums[right + 1] && right+1 < nums.length - 1){
                            right++;
                        }
                        if (nums[right] > nums[left] && nums[right + 1] < nums[right]) {
                            count++;
                            left = right;
                        }else if(nums[right] < nums[left] && nums[right + 1] > nums[right]){
                            count++;
                            left = right;
                        }else {
                            left = right;
                        }
                        break;
                    }else {
                        left = right;
                        break;
                    }
                }
            }else {
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{57,57,57,57,57,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,85,85,85,86,86,86};
        System.out.println(solution(nums));
    }

}
