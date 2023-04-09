package LeetCodeRankWeek_2023._340_week;

// @date 2023/4/9
// @time 10:23
// @author zhangzhi
// @description

import java.util.*;

public class second {

    public static long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                List<Integer> list = map.get(nums[i]);
                list.add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        long[] arr = new long[nums.length];
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            if(list.size() == 1){
                continue;
            }
            long sum = 0;
            for(int i = 1; i < list.size(); i++){
                sum += list.get(i) - list.get(0);
            }
            arr[list.get(0)] = sum;
            for(int i = 1; i < list.size(); i++){
                int diff = list.get(i) - list.get(i - 1);
                arr[list.get(i)] = arr[list.get(i - 1)] + (2L * i - list.size()) * diff;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,5,3};
        System.out.println(Arrays.toString(distance(nums)));
    }
}
