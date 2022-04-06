package LeetCodeSpringRecruitment_2022.four_week.day_four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/4/6
 * @TIME 21:44
 * @Created by zhangzhi
 * @description LeetCode 18 题 四数之和
 */
public class _4Sum {

    /**
     * @create zhangzhi
     * @date 2022/4/6
     * @time 21:45
     * @description
     * 思路：
     *      三数之和可以用一个 for 加 双指针，是因为有一个 nums[a] 在 for 中被确定
     *      所以只需要在剩下的数组中找 nums[b]+nums[c] 即可。
     *      同理，四数之和就要 两层  for + 双指针，先确定 nums[a]+nums[b],然后用双指针找
     *      nums[c]+nums[d]即可
     *      注意去重！！！
     */
    public static List<List<Integer>> solution(int[] nums, int target){
        if (nums.length < 4){
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); //数组需要排序，这样才方便用双指针查找
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]){ //不能重复
                continue;
            }
            for (int j = i + 1; j < nums.length;j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){// 不能重复
                    continue;
                }

                // 双指针
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target){// 如果大于 target，说明 right 指针需要向左移
                        right--;
                        // 左移的同时，需要保证不能重复
                        while (left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }else if (sum < target){//如果小于 target，说明 left 指针需要向右移
                        left++;
                        // 右移的同时，需要保证不能重复
                        while (left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                    }else {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[left]);
                        list1.add(nums[right]);
                        list.add(list1);

                        // 找到一组解后，需要同时缩小 left 和 right
                        while (left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]){
                            left++;
                        }

                        right--;
                        left++;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        System.out.println(solution(nums,0));
    }
}
