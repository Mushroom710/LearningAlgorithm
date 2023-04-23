package LeetCodeRankWeek_2023._342_week;

import java.util.*;

// @date 2023/4/23
// @time 10:34
// @author zhangzhi
// @description
public class three {

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        int pivotIndex = partition(arr, left, right);
        if (pivotIndex == k - 1) {
            return arr[pivotIndex];
        } else if (pivotIndex > k - 1) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for(int i = 0; i < n - k + 1; i++){
//            PriorityQueue<Integer> pq = new PriorityQueue<>();
//            for(int j = i; j < i + k; j++){
//                pq.add(nums[j]);
//            }
//            for(int l = 0; l < x - 1; l++){
//                pq.poll();
//            }
//            if(pq.peek() < 0){
//                ans[i] = pq.poll();
//            }
//            List<Integer> list = new ArrayList<>(k);
//            for(int j = i; j < i + k; j++){
//                list.add(nums[j]);
//            }
//            Collections.sort(list);
//            if(list.get(x - 1) < 0){
//                ans[i] = list.get(x - 1);
//            }
            int[] arr = new int[k];
            int l = i;
            for(int j = 0; j < k; j++){
                arr[j] = nums[l++];
            }
            int val = quickSelect(arr, 0, k - 1, x);
            if(val < 0){
                ans[i] = val;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,-3,-2,3};
        System.out.println(Arrays.toString(getSubarrayBeauty(nums, 3, 2)));
    }
}
