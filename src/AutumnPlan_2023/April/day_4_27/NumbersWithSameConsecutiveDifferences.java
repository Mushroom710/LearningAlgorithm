package AutumnPlan_2023.April.day_4_27;

import java.util.ArrayList;
import java.util.List;

// @date 2023/4/27
// @time 16:06
// @author zhangzhi
// @description LeetCode 967. 连续差相同的数字
// 原来是回溯题，昨天真没想到这层。
public class NumbersWithSameConsecutiveDifferences {

    private int n;
    private int k;
    private int[] path;
    private List<Integer> ans;
    private int start;
    private int end;

    private void dfs(int i){
        if(i == n){
            int num = 0;
            for(int j = n - 1; j >= 0; j--){
                num += (int)path[j] * Math.pow(10, j);
            }

            if(num >= start && num <= end){
                ans.add(num);
            }
            return;
        }

        for(int j = 0; j <= 9; j++){
            if(i == 0){
                path[i] = j;
                dfs(i + 1);
            }else{
                if(Math.abs(j - path[i - 1]) == k){
                    path[i] = j;
                    dfs(i + 1);
                }
            }
        }
    }

    public int[] numsSameConsecDiff(int n, int k) {
        this.n = n;
        this.k = k;
        this.ans = new ArrayList<>();
        this.path = new int[n];
        this.start = (int)Math.pow(10, n - 1);
        this.end = (int)Math.pow(10, n) - 1;

        dfs(0);

        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}
