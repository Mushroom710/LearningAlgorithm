package LeetCodeRankWeek._295_week_patch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @DATE 2022/6/3
 * @TIME 0:52
 * @Created by zhangzhi
 * @description
 */
public class second {

    public static String discountPrices(String sentence, int discount){
        String[] ss = sentence.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ss.length;i++){
            if (ss[i].charAt(0) == '$'){
                String price_s = ss[i].substring(1);
                if (price_s.equals(""))continue;
                if (price_s.contains("$"))continue;
                Pattern p = Pattern.compile("[a-z]]");
                Matcher m = p.matcher(price_s);
                if (m.matches())continue;
                long price = Long.parseLong(price_s);
                double d_price = 1.0 * price * (1 - 1.0 * discount / 100);
                String re = String.format("%.2f",d_price);
                ss[i] = "$" + re;
            }
        }
        for (int i = 0;i < ss.length - 1;i++){
            sb.append(ss[i]).append(" ");
        }
        sb.append(ss[ss.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        String sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$";
        System.out.println(discountPrices(sentence,100));
    }
}
