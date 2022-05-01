package LeetCodeRankWeek._291_week;

/**
 * @DATE 2022/5/1
 * @TIME 10:32
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static String replace(String number,int idx){
        char[] chs = new char[number.length() - 1];
        for (int i = 0;i < idx;i++){
            chs[i]  = number.charAt(i);
        }
        for (int i = idx + 1;i < number.length();i++){
            chs[i - 1] = number.charAt(i);
        }
        return new String(chs);
    }
    public static String  compare(String max,String tmp){
        for (int i = 0;i < max.length();i++){
            if (max.charAt(i) == tmp.charAt(i)){
                continue;
            }else if (max.charAt(i) < tmp.charAt(i)){
                return tmp;
            }else{
                return max;
            }
        }
        return max;
    }

    public static String solution(String number,char digit){
        String max = "";
        for (int i = 0;i < number.length();i++){
            if (number.charAt(i) == digit){
                String tmp = replace(number,i);
                if ("".equals(max)){
                    max = tmp;
                }else {
                    max = compare(max,tmp);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String number = "551";
        System.out.println(solution(number,'5'));
    }
}
