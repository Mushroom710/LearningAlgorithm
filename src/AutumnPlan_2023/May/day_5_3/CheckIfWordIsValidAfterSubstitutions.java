package AutumnPlan_2023.May.day_5_3;

import java.util.Deque;

// @date 2023/5/3
// @time 21:43
// @author zhangzhi
// @description 每日一题 LeetCode 1003. 检查替换后的词是否有效
public class CheckIfWordIsValidAfterSubstitutions {

    // 笨方法就是遍历，找 abc，然后把后面的字符移到前面
    public static boolean isValid(String s) {
        char[] chs = s.toCharArray();
        int len = s.length();
        while(len != 0){
            int pre = len;
            for(int i = 0; i <= len - 3; i++){
                if(chs[i] == 'a' && chs[i + 1] == 'b' && chs[i + 2] == 'c'){
                    for(int j = i; j < len - 3; j++){
                        chs[j] = chs[j + 3];
                    }
                    len -= 3;
                    break;
                }
            }
            if(len == pre){
                return false;
            }
        }
        return true;
    }

    // 和括号匹配那题是一样的思路
    // 如果最后的三个字符是 abc，就删除
    // 最后，如果 sb 长度为 0，说明是有效的
    public static boolean isValid2(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(sb.length() >= 3 && "abc".equals(sb.substring(sb.length() - 3))){
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        return sb.length() == 0;
    }

    public static void main(String[] args) {
        String s = "aabcbc";
        //System.out.println(isValid(s));
        System.out.println(isValid2(s));
    }
}
