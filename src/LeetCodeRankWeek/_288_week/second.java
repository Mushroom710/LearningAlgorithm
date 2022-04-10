package LeetCodeRankWeek._288_week;

/**
 * @DATE 2022/4/10
 * @TIME 11:16
 * @Created by zhangzhi
 * @description
 */
public class second {

    static int nMin = Integer.MAX_VALUE;
    static String sMin = "";

    private static int sum(char[] chs,int l,int r){
        int sum = chs[r];
        int pow = 10;
        for(r = r - 1;r >= l; r--) {
            sum += (chs[r] - 48) * pow;
            pow *= 10;
        }
        return sum;
    }

    private static void calc(char[] chs,int l1,int r1,int l2,int r2){
        int lsum = sum(chs,l1,r1);
        int rsum = sum(chs,l2,r2);
        int tmp = lsum + rsum;
        int l = sum(chs,0,l1);
        int r = sum(chs,r2,chs.length - 1);
        tmp = l*(tmp)*r;
        nMin = Math.min(nMin,tmp);
        sMin = "l(lsum+rsum)r";
    }

    private static void calc1(char[] chs,int l1,int r1,int l2,int r2){
        String ls = String.valueOf(chs,0,r1);
        System.out.println(ls);
    }

    private static void recursive(char[] chs,int l1,int r1,int l2,int r2){
        if(l1 > r1 || l2 > r2){
            return;
        }
        calc(chs,l1,r1,l2,r2);
        calc1(chs,l1,r1,l2,r2);
        recursive(chs,l1+1,r1,l2,r2);
        recursive(chs,l1,r1,l2,r2+1);
    }

    public static String solution(String expression){
        char[] chs = expression.toCharArray();
        int num1 = 0;
        for (char c : chs){
            if (c == '+'){
                break;
            }
            num1++;
        }
        recursive(chs,0,num1 - 1,num1 + 1,chs.length - 1);
        return "";
    }

    public static String minimizeResult(String expression) {
        String result = "", split[] = expression.split("\\+");
        for (int i = 0, min = Integer.MAX_VALUE; i < split[0].length(); i++) {
            for (int j = 1; j <= split[1].length(); j++) {
                int curr = (i > 0 ? Integer.parseInt(split[0].substring(0, i)) : 1)
                        * (Integer.parseInt(split[0].substring(i)) + Integer.parseInt(split[1].substring(0, j)))
                        * (j < split[1].length() ? Integer.parseInt(split[1].substring(j)) : 1);
                if (curr < min) {
                    min = curr;
                    result = split[0].substring(0, i) + '(' + split[0].substring(i) + '+' + split[1].substring(0, j)
                            + ')' + split[1].substring(j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "247+138";
//        solution(s);
//        System.out.println(sMin);
//        System.out.println(nMin);

        System.out.println(minimizeResult(s));
    }
}
