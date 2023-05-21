package LeetCodeRankWeek_2023._346_week;

// @date 2023/5/21
// @time 10:29
// @author zhangzhi
// @description
public class first {
    public int minLength(String s) {
        while(s.contains("AB") || s.contains("CD")){
            if(s.contains("AB")){
                s = s.replaceAll("AB", "");
            }
            if(s.contains("CD")){
                s = s.replaceAll("CD", "");
            }
        }
        return s.length();
    }
}
