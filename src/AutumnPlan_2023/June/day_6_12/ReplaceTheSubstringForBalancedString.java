package AutumnPlan_2023.June.day_6_12;

// @date 2023/6/12
// @time 10:08
// @author zhangzhi
// @description LeetCode 1234. 替换子串得到平衡字符串
public class ReplaceTheSubstringForBalancedString {
    public int balancedString(String s) {
        int[] cnt = new int['Z'];
        int n = s.length();
        for(int i = 0; i < n; i++){
            cnt[s.charAt(i)]++;
        }
        int t = n / 4;
        if(cnt['Q'] == t && cnt['W'] == t && cnt['E'] == t && cnt['R'] == t){
            return 0;
        }
        int ans = n + 1;
        int l = 0;
        for(int r = 0; r < n; r++){
            cnt[s.charAt(r)]--;
            while(cnt['Q'] <= t && cnt['W'] <= t && cnt['E'] <= t && cnt['R'] <= t){
                ans = Math.min(ans, r - l + 1);
                cnt[s.charAt(l)]++;
                l++;
            }
        }
        return ans;
    }
}
