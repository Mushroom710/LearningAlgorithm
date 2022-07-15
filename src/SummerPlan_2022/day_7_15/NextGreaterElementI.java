package SummerPlan_2022.day_7_15;

import java.util.*;

/**
 * @DATE 2022/7/15
 * @TIME 21:12
 * @Created by zhangzhi
 * @description LeetCode 496 题 下一个更大元素 I
 */
public class NextGreaterElementI {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums2.length;i++){
            map.put(nums2[i],i);
        }
        int[] ans = new int[nums1.length];
        Arrays.fill(ans,-1);
        for (int i = 0;i < nums1.length;i++){
            for (int j = map.get(nums1[i]);j < nums2.length;j++){
                if (nums1[i] < nums2[j]){
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }

    public static int[] simple_stack_nextGreaterElement(int[] nums1, int[] nums2){
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0;i < nums2.length;i++){
            if (!deque.isEmpty() && deque.peekLast() <= nums2[i]) {
                while (!deque.isEmpty() && deque.peekLast() < nums2[i]) {
                    map.put(deque.pollLast(), nums2[i]);
                }
            }
            deque.addLast(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0;i < nums1.length;i++){
            ans[i] = map.getOrDefault(nums1[i],-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
        System.out.println(Arrays.toString(simple_stack_nextGreaterElement(nums1,nums2)));
    }
}
