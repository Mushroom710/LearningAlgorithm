package LeetCodeRankWeek_2023._336_week;

// @date 2023/3/12
// @time 10:22
// @author zhangzhi
// @description

public class first {

    public static int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++){
            if(words[i].charAt(0) == 'a' || words[i].charAt(0) == 'e' || words[i].charAt(0) == 'i' ||
            words[i].charAt(0) == 'o' || words[i].charAt(0) == 'u'){
                int len = words[i].length();
                if(words[i].charAt(len - 1) == 'a' || words[i].charAt(len - 1) == 'e' || words[i].charAt(len - 1) == 'i' ||
                words[i].charAt(len - 1) == 'o' || words[i].charAt(len - 1) == 'u'){
                    count++;
                }
            }
        }
        return count;
    }
}
