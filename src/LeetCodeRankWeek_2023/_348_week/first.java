package LeetCodeRankWeek_2023._348_week;

// @date 2023/6/4
// @time 10:27
// @author zhangzhi
// @description
public class first {
    public int minimizedStringLength(String s) {
        boolean[] boo = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(boo[c - 'a']){
               continue;
            }
            boo[c - 'a'] = true;
            sb.append(c);
        }
        return sb.length();
    }
}
