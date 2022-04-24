package LeetCodeRankWeek._290_week;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @DATE 2022/4/24
 * @TIME 10:21
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static List<Integer> solution(int[][] nums){
        int[] ans = new int[1000 + 1];
        for (int[] arr : nums){
            for (int val : arr){
                ans[val]++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1;i < ans.length;i++){
            if (ans[i] == nums.length){
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {

    }
}
