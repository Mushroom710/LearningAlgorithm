package LeetCodeRankWeek_2023._349_week;

// @date 2023/6/11
// @time 10:07
// @author zhangzhi
// @description
public class second {

    public String smallestString(String s) {
        char[] chs = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(chs[i] != 'a'){
                for(int j = i; j < s.length(); j++){
                    if(chs[j] == 'a'){
                        break;
                    }
                    chs[j] = (char)(chs[j] - 1);
                }
                return new String(chs);
            }
        }
        chs[s.length() - 1] = 'z';
        return new String(chs);
    }

    public static void main(String[] args) {
        String s = "abbbab";
        System.out.println(new second().smallestString(s));
    }
}
