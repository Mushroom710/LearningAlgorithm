package LeetCodeSpringRecruitment_2022.third_week.day_five;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @DATE 2022/4/1
 * @TIME 14:19
 * @Created by zhangzhi
 * @description LeetCode 349 题 两个数组的交集
 * 输入的数组不一定是有序的，要使用二分查找，数组需要有序
 * 思路：
 * 假设 num1.length<nums2.length
 * 从 nums1 中取出一个元素，在 nums2 中进行二分查找，能找到，说明两个数组都有
 * 同时，还需要对 nums1 的元素去重，这里用 HashSet
 *
 * 二分查找的前提是数组有序：
 *  只需要对需要二分查找的那个数组进行排序即可，不用两个数组都排序。
 */
public class IntersectionOfTwoArrays {

    /**
     * @create zhangzhi
     * @date 2022/4/1
     * @time 14:52
     * @description 这种重构代码的思路雀食厉害
     */
    public static int[] solution(int[] nums1,int[] nums2){
        HashSet<Integer> set = new HashSet<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[Math.min(len1,len2)];
        int idx = 0;
        if(len1 > len2){
            idx = getIdx(nums1, nums2, set, len1, len2, ans, idx);
        }else{
            idx = getIdx(nums2, nums1, set, len2, len1, ans, idx);
        }

        return Arrays.copyOfRange(ans,0,idx);
    }

    /**
     * @create zhangzhi
     * @date 2022/4/1
     * @time 14:53
     * @description 这一块我之前都不知道该怎么重构提取出一个函数，IDEA雀食厉害
     */
    private static int getIdx(int[] nums1, int[] nums2, HashSet<Integer> set, int len1, int len2, int[] ans, int idx) {
        Arrays.sort(nums1);
        for(int i = 0; i < len2; i++){
            if(set.add(nums2[i])){
                if (BinarySearch(0,len1-1,nums1,nums2[i])) {
                    ans[idx] = nums2[i];
                    idx++;
                }
            }
        }
        return idx;
    }

    /**
     * @create zhangzhi
     * @date 2022/4/1
     * @time 14:50
     * @description 这是没有重构前的我写的代码，我自己觉得不够简洁
     * 上面那一套是IDEA自动重构的代码，真的简洁清晰
     */
    public static int[] CodeByMe(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = new int[Math.min(len1,len2)];
        int idx = 0;
        if(len1 > len2){
            for(int i = 0; i < len2; i++){
                if(set.add(nums2[i])){
                    if (BinarySearch(0,len1-1,nums1,nums2[i])) {
                        ans[idx] = nums2[i];
                        idx++;
                    }
                }
            }
        }else{
            for(int i = 0; i < len1; i++){
                if(set.add(nums1[i])){
                    if (BinarySearch(0,len2-1,nums2,nums1[i])) {
                        ans[idx] = nums1[i];
                        idx++;
                    }
                }
            }
        }

        return Arrays.copyOfRange(ans,0,idx);
    }

    public static boolean BinarySearch(int left,int right,int[] nums,int target){
        while (left <= right){
            int mid = left + (right - left ) / 2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(solution(nums1,nums2)));
    }
}
