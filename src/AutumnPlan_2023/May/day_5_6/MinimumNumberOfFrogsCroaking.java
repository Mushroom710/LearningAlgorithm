package AutumnPlan_2023.May.day_5_6;

import java.util.HashMap;
import java.util.Map;

// @date 2023/5/6
// @time 22:33
// @author zhangzhi
// @description 每日一题 LeetCode 1419. 数青蛙
public class MinimumNumberOfFrogsCroaking {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] cnt = new int['s'];
        Map<Character, Character> map = new HashMap<>();
        map.put('c', 'k');
        map.put('r', 'c');
        map.put('o', 'r');
        map.put('a', 'o');
        map.put('k', 'a');
        for(int i = 0; i < croakOfFrogs.length(); i++){
            char ch = croakOfFrogs.charAt(i);
            char pre = map.get(ch);
            if(cnt[pre] > 0){
                cnt[pre]--;
            }else if(ch != 'c'){
                return -1;
            }
            cnt[ch]++;
        }
        if(cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0){
            return -1;
        }
        return cnt['k'];
    }
}
