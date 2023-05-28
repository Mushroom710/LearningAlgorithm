package LeetCodeRankWeek_2023._347_week;

// @date 2023/5/28
// @time 10:50
// @author zhangzhi
// @description
public class three {

    public long minimumCost(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 1; i < n; i++){
            if(s.charAt(i - 1) != s.charAt(i)){
                ans += Math.min(i, n - i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "0011";
        System.out.println(new three().minimumCost(s));
    }
}
