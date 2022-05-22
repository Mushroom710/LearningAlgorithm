package LeetCodeRankWeek._294_week;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @DATE 2022/5/22
 * @TIME 11:38
 * @Created by zhangzhi
 * @description
 */
public class four {

    static int ans;
    public static void backtracking(int[] strength,int startIdx,List<Integer> path){
        if (startIdx >= strength.length)return;
        if (path.size() > 0){
            Collections.sort(path);
            int sum = 0;
            for (int i = 0; i < path.size();i++){
                sum = sum + path.get(i) % (1000000007);
            }
            ans = ans + path.get(0) * sum % (1000000007);
        }
        for (int i = startIdx; i < strength.length;i++){
            path.add(strength[i]);
            backtracking(strength,i + 1,path);
            path.clear();
        }
    }

    public static int totalStrength(int[] strength){
        List<Integer> path = new ArrayList<>();
        backtracking(strength,0,path);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,6};
        System.out.println(totalStrength(nums));
    }
}
