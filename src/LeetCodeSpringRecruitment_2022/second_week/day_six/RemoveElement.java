package LeetCodeSpringRecruitment_2022.second_week.day_six;

/**
 * @DATE 2022/3/26
 * @TIME 20:23
 * @Created by zhangzhi
 * @description LeetCode 27 题 移除元素
 */
public class RemoveElement {

    /**
     * @create zhangzhi
     * @date 2022/3/26
     * @time 20:30
     * @description 暴力解法。找到能移除的元素后，把后面的元素向前移动一位。
     * 数组大小减小1，外层for循环变量i减1。
     */
    public static int solution(int[] nums, int val){
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                size--;
                i--;
            }
        }
        return size;
    }

    /**
     * @create zhangzhi
     * @date 2022/3/27
     * @time 20:38
     * @description 双指针法。当找到一个 nums[quick] == val 时，
     * 进入下一个循环，用后面一个元素来覆盖它
     */
    public static int solution_two(int[] nums, int val){
        int slow = 0;
        for (int quick = 0; quick < nums.length; quick++){
            if(val != nums[quick]){
                nums[slow] = nums[quick];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
//        System.out.println(solution(nums,3));
        System.out.println(solution_two(nums,3));
    }
}
