package AutumnPlan_2023.April.day_4_26;

// @date 2023/4/26
// @time 21:56
// @author zhangzhi
// @description LeetCode 942. 增减字符串匹配
public class DIStringMatch {

    public int[] diStringMatch(String s) {
        int len = s.length();
        int[] ans = new int[len + 1];
        int left = 0;
        int right = len;
        for(int i = 0, k = 0; i < len; i++, k++){
            if(s.charAt(i) == 'I'){
                ans[k] = left++;
            }else{
                ans[k] = right--;
            }
        }
        ans[len] = left;
        return ans;
    }
}
