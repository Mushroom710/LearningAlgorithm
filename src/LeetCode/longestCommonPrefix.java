package LeetCode;

/**
 * @DATE 2022/3/18
 * @TIME 15:34
 * @Created by zhangzhi
 */
public class longestCommonPrefix {

    public static String solution(String[] strs){
        if(strs.length == 1){
            return strs[0];
        }
        int n = strs.length;
        int min = Integer.MAX_VALUE;
        StringBuilder ans = new StringBuilder();

        for (String str : strs) {
            min = Math.min(min, str.length());
        }

        int flag = 0;
        for(int i = 0; i < min; i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j < n; j++){
                if(ch == strs[j].charAt(i)){
                    flag = 1;
                }else{
                    return String.valueOf(ans);
                }
            }
            if(flag == 1){
                ans.append(ch);
                flag = 0;
            }else {
                break;
            }
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        System.out.println(solution(strs));
    }
}
