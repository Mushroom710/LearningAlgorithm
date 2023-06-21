package AutumnPlan_2023.June.day_6_21;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/21
// @time 10:54
// @author zhangzhi
// @description LeetCode 2698. 求一个整数的惩罚数
public class FindThePunishmentNumberOfAnInteger {
    boolean[] ans = new boolean[1001];
    List<Integer> path = new ArrayList<>();

    private void dfs(int i, String num, int target){
        if(i == num.length()){
            int sum = 0;
            for(int n : path){
                sum += n;
            }
            if(sum == target){
                ans[target] = true;
            }
            return;
        }

        for(int j = i; j < num.length(); j++){
            String sub = num.substring(i, j + 1);
            path.add(Integer.parseInt(sub));
            dfs(j + 1, num, target);
            path.remove(path.size() - 1);
        }
    }

    public int punishmentNumber(int n) {
        for(int i = 1; i <= n; i++){
            String num = String.valueOf(i * i);
            dfs(0, num, i);
        }
        int result = 0;
        for(int i = 1; i <= n; i++){
            if(ans[i]){
                result += i * i;
            }
        }
        return result;
    }
}
