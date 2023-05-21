package LeetCodeRankWeek_2023._346_week;

import java.util.*;

// @date 2023/5/21
// @time 10:52
// @author zhangzhi
// @description
public class three {

    private List<String> path;
    private Set<Integer> set;
    private boolean dfs(int start, int target, String s){
        if(start == s.length()){
            int sum = 0;
            for (String value : path) {
                int num = Integer.parseInt(value);
                sum += num;
            }
            if(sum == target){
                set.add(target);
                return true;
            }
        }
        for(int k = start; k < s.length(); k++){
            path.add(s.substring(start, k + 1));
            dfs(k + 1, target, s);
            path.remove(path.size() - 1);
        }
        return false;
    }

    public int punishmentNumber(int n) {
        this.path = new ArrayList<>();
        this.set = new HashSet<>();
        for(int i = 1; i <= n; i++){
            String s = String.valueOf(i * i);
            dfs(0, i, s);
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(set.contains(i)){
                ans += i * i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new three().punishmentNumber(1000));
    }
}
