package AutumnPlan_2023.May.day_5_18;

// @date 2023/5/18
// @time 11:21
// @author zhangzhi
// @description
public class MinimumWindowSubstring {

    private int[] tcnt = new int['z'];
    private int[] cnt = new int['z'];

    private char[] tchs;

    private boolean check(){
        for(char c : tchs){
            if(cnt[c - 'A'] < tcnt[c - 'A']){
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        this.tchs = t.toCharArray();
        for(int i = 0; i < t.length(); i++){
            tcnt[t.charAt(i) - 'A']++;
        }
        // 左端点和右端点
        int l = 0, r = -1;
        // 记录最短子串的长度
        int len = Integer.MAX_VALUE;
        int sLen = s.length();
        // 截取的子串起始位置和结束位置
        int ansL = -1, ansR = -1;
        while(r < sLen){
            // 扩展右端点
            r += 1;
            // 统计窗口元素
            if(r < sLen && tcnt[s.charAt(r) - 'A'] > 0){
                cnt[s.charAt(r) - 'A']++;
            }
            // l 和 r 可以重合，此时子串长度为 1
            while(check() && l <= r){
                if(r - l + 1 < len){
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                // 收缩左端点
                if(tcnt[s.charAt(l) - 'A'] > 0){
                    cnt[s.charAt(l) - 'A']--;
                }
                l += 1;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }
}
