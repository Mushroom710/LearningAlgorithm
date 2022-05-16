package LeetCodeSpringRecruitment_2022.ten_week.day_one;

import java.util.ArrayList;
import java.util.List;

/**
 * @DATE 2022/5/16
 * @TIME 21:06
 * @Created by zhangzhi
 * @description LeetCode 39 题 组合总和
 * 本题还需要startIndex来控制for循环的起始位置，对于组合问题，什么时候需要 startIndex 呢？
 *  1.如果是一个集合来求组合的话，就需要 startIndex，例如：77.组合，216.组合总和 III。
 *  2.如果是多个集合取组合，各个集合之间相互不影响，那么就不用 startIndex，例如：17.电话号码的字母组合
 */
public class CombinationSum {

    static List<List<Integer>> ans;
    static List<Integer> path;
    public static void backtracking(int[] candidates,int target,int sum,int startIndex){
        // 终止只有两种情况，sum 大于 target 和 sum 等于 target
        if (sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }else if (sum > target)return;

        // 剪枝优化：首先 candidates 是有序的
        // 对总集合排序之后，如果下一层的sum（就是本层的 sum + candidates[i]）
        // 已经大于target，就可以结束本轮for循环的遍历。
        // (;i < candidates.length && sum + candidates[i] <= target;)
        for (int i = startIndex;i < candidates.length;i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum,i);// 关键点:不用i+1了，表示可以重复读取当前的数
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        ans = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(candidates,target,0,0);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
}
