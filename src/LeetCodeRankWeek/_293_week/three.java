package LeetCodeRankWeek._293_week;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @DATE 2022/5/15
 * @TIME 11:03
 * @Created by zhangzhi
 * @description
 */
public class three {

    static int max;
    static List<Integer> path;
    static Set<Integer> set;

    public static void backtracking(int startIdx,int[] candidates,int sum){
        if (startIdx >= candidates.length || candidates.length - startIdx < max || sum == 0)return;
        for (int i = startIdx;i < candidates.length;i++){
            if (path.size() == 1)sum = candidates[i];
//            if (!set.add(candidates[i]))return;
           path.add(candidates[i]);
           int tmp;
           if (sum == -1){
               sum = candidates[i];
               tmp = sum;
           }else {
               tmp = sum;
               sum = sum & candidates[i];
           }
           if (sum > 0){
               max = Math.max(max,path.size());
//               System.out.println(path);
           }
           backtracking(i + 1,candidates,sum);
           path.remove(path.size() - 1);
           sum = tmp;
//           set.remove(candidates[i]);
        }
    }

    public static int largestCombination(int[] candidates){
        max = 0;
        path = new ArrayList<>();
        set = new HashSet<>();
        backtracking(0,candidates,-1);
        return max;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/15
     * @time 21:43
     * @description 没想到居然是用位运算解的
     * 只要统计出在某一位出现 1 最多的位即可
     */
    public static int right_solution(int[] candidates){
        int[] bitcount = new int[24];
        int max = 0;
        for (int i = 0;i < 24;i++){
            for (int j = 0;j < candidates.length;j++){
                if (((candidates[j] >> i) & 1) == 1){
                    bitcount[i]++;
                }
            }
            max = Math.max(max,bitcount[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestCombination(new int[]{84,40,66,44,91,90,1,14,73,51,47,35,18,46,18,65,55,18,16,45,43,58,90,92,91,43,44,76,85,72,24,89,60,94,81,90,86,79,84,41,41,28,44}));
        System.out.println(right_solution(new int[]{33,93,31,99,74,37,3,4,2,94,77,10,75,54,24,95,65,100,41,82,35,65,38,49,85,72,67,21,20,31}));
//        System.out.println(1 & 8);
    }
}
