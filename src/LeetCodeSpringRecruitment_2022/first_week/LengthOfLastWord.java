package LeetCodeSpringRecruitment_2022.first_week;

/**
 * @DATE 2022/3/19
 * @TIME 20:05
 * @Created by zhangzhi
 * @description LeetCode 58 题 最后一个单词的长度
 */
public class LengthOfLastWord {

    public static int solution(String s){
        String[] strs = s.split(" ");
        return strs[strs.length-1].length();
    }

    public static void main(String[] args) {
        System.out.println(solution("   fly me   to   the moon  "));
    }
}
