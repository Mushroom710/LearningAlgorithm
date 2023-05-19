package AutumnPlan_2023.May.day_5_19;

// @date 2023/5/19
// @time 10:02
// @author zhangzhi
// @description LeetCode 1234. 替换子串得到平衡字符串
public class ReplaceTheSubstringForBalancedString {
    public int balancedString(String s) {
        int[] cnt = new int['Z'];
        char[] chs = s.toCharArray();
        for(char c : chs){
            cnt[c]++;
        }
        int len = s.length();
        int count = len / 4;
        if(cnt['Q'] == count && cnt['W'] == count && cnt['E'] == count && cnt['R'] == count){
            return 0;
        }
        int left = 0;
        int ans = len;
        for(int right = 0; right < len; right++){
            cnt[chs[right]] -= 1;
            while(cnt['Q'] <= count && cnt['W'] <= count && cnt['E'] <= count && cnt['R'] <= count){
                ans = Math.min(ans, right - left + 1);
                cnt[chs[left]] += 1;
                left++;
            }
        }
        return ans;
    }
}
