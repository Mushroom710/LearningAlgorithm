package LeetCodeRankWeek_2023._346_week;

// @date 2023/5/21
// @time 10:29
// @author zhangzhi
// @description
public class second {

    private char[] chs;

    private int dfs(int i, int j){
        if(i >= j){
            return 0;
        }
        if(chs[i] > chs[j]){
            chs[i] = chs[j];
        }else{
            chs[j] = chs[i];
        }
        return dfs(i + 1, j - 1);
    }
    public String makeSmallestPalindrome(String s) {
        this.chs = s.toCharArray();
        dfs(0, s.length() - 1);
        return new String(chs);
    }

    public String make(String s){
        char[] chss = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while(l <= r){
            if(chss[l] > chss[r]){
                chss[l] = chss[r];
            }else{
                chss[r] = chss[l];
            }
            l++;
            r--;
        }
        return new String(chss);
    }

    public static void main(String[] args) {
        String s = "egcfe";
        System.out.println(new second().makeSmallestPalindrome(s));
    }
}
