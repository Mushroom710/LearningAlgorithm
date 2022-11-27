package LeetCodeRankWeek._321_week;

// @date 2022/11/27
// @time 10:23
// @author zhangzhi
// @description 第 321 场周赛 第二题 追加字符以获得子序列
// 一开始以为是动态规划，仔细分析后发现，不需要把所有的字符都比较一次，只需要比较部分字符即可。
// 统计 t 中的前缀字符是否出现在 s 中，一旦匹配上，就把匹配的下标记录下来，作为下一次匹配的开始，结束本次循环
// 如果本次没有匹配上，就不需要比较 t 之后的字符了，直接返回
// 然后 用 t.length() - count 就是需要添加的字符个数

public class second {

    public static int appendCharacters(String s, String t) {
        int idx = -1;
        int count = 0;
        for(int i = 0; i < t.length(); i++) {
            for(int j = idx + 1; j < s.length(); j++) {
                if(t.charAt(i) == s.charAt(j)) {
                    idx = j;
                    count++;
                    break;
                }
                if(j == s.length() - 1){
                    return t.length() - count;
                }
            }
        }
        return t.length() - count;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "abcdee";
        System.out.println(appendCharacters(s, t));
    }
}
