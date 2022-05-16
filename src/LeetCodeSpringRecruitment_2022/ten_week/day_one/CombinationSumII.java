package LeetCodeSpringRecruitment_2022.ten_week.day_one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/5/16
 * @TIME 21:39
 * @Created by zhangzhi
 * @description LeetCode 40 题 组合总和 II
 * 关键在于怎么去重，这个首先需要对集合排序，让相同的元素在一块
 * 如果 candidates[i] == candidates[i - 1] 并且 used[i - 1] == false，
 * (注意：树枝和树层的区别)
 * 就说明：前一个树枝，使用了 candidates[i - 1]，也就是说同一树层使用过 candidates[i - 1]。
 *  1.used[i - 1] == true，说明同一树枝 candidates[i - 1] 使用过
 *  2.used[i - 1] == false，说明同一树层 candidates[i - 1] 使用过
 */
public class CombinationSumII {

    static List<List<Integer>> ans;
    static List<Integer> path;
    public static void backtracking(int[] candidates,int target,int sum,int startIndex,boolean[] used){
        if (sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }else if (sum > target)return;

        for (int i = startIndex;i < candidates.length;i++){
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i > 0 && candidates[i - 1] == candidates[i] && !used[i - 1])continue;
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            System.out.println(Arrays.toString(used));
            System.out.println(path);
            // 和39.组合总和的区别1，这里是i+1，每个数字在每个组合中只能使用一次
            backtracking(candidates,target,sum,i + 1,used);
            used[i] = false;
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        // 首先把给candidates排序，让其相同的元素都挨在一起。
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        path = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        backtracking(candidates,target,0,0,used);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{1,1,1,2},3));
    }
}
