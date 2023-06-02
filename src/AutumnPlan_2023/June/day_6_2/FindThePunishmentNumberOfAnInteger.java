package AutumnPlan_2023.June.day_6_2;

import java.util.ArrayList;
import java.util.List;

// @date 2023/6/2
// @time 9:05
// @author zhangzhi
// @description LeetCode 2698. 求一个整数的惩罚数

public class FindThePunishmentNumberOfAnInteger {
    static boolean[] isPun = new boolean[1001];

    static List<String> path = new ArrayList<>();

    private static void dfs(int start, int target, String s){
        if(start == s.length()){
            int sum = 0;
            for(String num : path){
                sum += Integer.parseInt(num);
            }
            if(sum == target){
                isPun[target] = true;
            }
            return;
        }

        for(int j = start; j < s.length(); j++){
            path.add(s.substring(start, j + 1));
            dfs(j + 1, target, s);
            path.remove(path.size() - 1);
        }
    }

    static{
        for(int i = 1; i <= 1000; i++){
            int target = i * i;
            dfs(0, i, String.valueOf(target));
        }
    }

    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(isPun[i]){
                ans += i * i;
            }
        }
        return ans;
    }
}
