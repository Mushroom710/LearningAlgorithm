package LeetCodeRankWeek._294_week;

/**
 * @DATE 2022/5/22
 * @TIME 10:20
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static int percentageLetter(String s, char letter){
        int count = 0;
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == letter){
                count++;
            }
        }
        System.out.println(1.0 * count / s.length());
        return (int)((1.0 * count / s.length()) * 100);
    }

    public static void main(String[] args) {
        System.out.println(percentageLetter("foobar",'o'));
    }
}
