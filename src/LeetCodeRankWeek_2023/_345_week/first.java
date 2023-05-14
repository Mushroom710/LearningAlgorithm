package LeetCodeRankWeek_2023._345_week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @date 2023/5/14
// @time 10:25
// @author zhangzhi
// @description
public class first {

    public static int[] circularGameLosers(int n, int k) {
        int[] cnt = new int[n];
        int round = 1;
        cnt[0] = 1;
        int idx = 0;
        while(true){
            idx = (idx + round * k) % n;
            cnt[idx]++;
            if(cnt[idx] == 2){
                break;
            }
            round++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if(cnt[i] == 0){
                list.add(i + 1);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularGameLosers(5, 2)));
    }
}
