package AutumnPlan_2022.day_10_12;

// @date 2022/10/12
// @time 10:15
// @author zhangzhi
// @description LeetCode 1790  仅执行一次字符串交换能否使两个字符串相等
// 缝缝补补又是一题

public class leetcode_1790 {

    public static boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        char[][] chs = new char[2][2];
        int[] idx = new int[2];
        int flag = 2;
        int j = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                chs[0][j] = s1.charAt(i);
                chs[1][j] = s2.charAt(i);
                idx[j] = i;
                j++;
                flag--;
            }
            if(flag == 0) {
                break;
            }
        }
        if(flag != 0) {
            return false;
        }
        if(chs[0][0] == chs[1][1] && chs[0][1] == chs[1][0]){
            char[] chs1 = s1.toCharArray();
            char tmp = chs1[idx[0]];
            chs1[idx[0]] = chs1[idx[1]];
            chs1[idx[1]] = tmp;
            s1 = new String(chs1);
        }
        return s1.equals(s2);
    }

    public static void main(String[] args){
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(areAlmostEqual(s1,s2));
    }
}
