package LeetCodeSpringRecruitment_2022.nine_week.day_six;

import java.util.ArrayList;
import java.util.List;

/**
 * @DATE 2022/5/14
 * @TIME 21:50
 * @Created by zhangzhi
 * @description LeetCode 216 题 组合总和 III
 * 搞懂 77 题 ，写这道题真的容易
 */
public class CombinationSumIII {

    static List<List<Integer>> ans;
    static List<Integer> path;
    public static void backtracking(int k,int n,int sum,int startIdx){
        if (sum > n)return;// 剪枝 -- 如果 sum > n，就没有继续递归的必要了
        if (sum == n && path.size() == k){// 找到 和为 n 且使用 k 个数
            ans.add(new ArrayList<>(path));// 同样需要注意全局变量的问题，需要新 new 一个对象保存
            return;
        }
        for (int i = startIdx;i <= 9; i++){// 限定了只能用 1-9
            path.add(i);
            sum += i;
            backtracking(k,n,sum,i + 1);// 注意i+1调整startIndex
            path.remove(path.size() - 1);// 回溯 -- 归去来兮
            sum -= i;
        }
    }
    public static List<List<Integer>> combinationSum3(int k, int n){
        ans = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(k,n,0,1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3,7));
    }
}
