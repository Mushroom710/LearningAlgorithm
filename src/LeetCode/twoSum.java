package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @DATE 2022/2/28
 * @Created by zhangzhi
 * @description LeetCode 1题 两数之和
 * 1.直接暴力解法。遍历数组，找到符合条件的下标
 * 2.用 HashMap 。因为 x+y=target，所以 x=target-y
 * 只需要遍历一次数组即可。
 */
public class twoSum {

    public static int[] solution(int[] nums,int target){
        //键是值，value是数组下标
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length ;i++){
            if(map.get(nums[i]) == null){
                map.put(target-nums[i],i);
            }else{
                return new int[]{map.get(nums[i]),i};
            }
        }//没有就返回null
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        System.out.println(Arrays.toString(solution(nums,6)));
    }
}
