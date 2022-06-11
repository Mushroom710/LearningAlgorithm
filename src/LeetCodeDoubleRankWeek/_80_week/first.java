package LeetCodeDoubleRankWeek._80_week;

/**
 * @DATE 2022/6/11
 * @TIME 22:28
 * @Created by zhangzhi
 * @description
 */
public class first {

    private static boolean haveLow(String password){
        for (int i = 0;i < password.length();i++){
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z'){
                return true;
            }
        }
        return false;
    }

    private static boolean haveUp(String password){
        for (int i = 0;i < password.length();i++){
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'){
                return true;
            }
        }
        return false;
    }
    private static boolean haveDigit(String password){
        for (int i = 0;i < password.length();i++){
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9'){
                return true;
            }
        }
        return false;
    }
    private static boolean haveOdd(String password){
        for (int i = 0;i < password.length();i++){
            if ((password.charAt(i) >= 33 && password.charAt(i) <= 45) || password.charAt(i) == '@' || password.charAt(i) == '^'){
                return true;
            }
        }
        return false;
    }

    private static boolean con(String password){
        for (int i = 1;i < password.length();i++){
            if (password.charAt(i) == password.charAt(i - 1)){
                return false;
            }
        }
        return true;
    }

    public static boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8){
            return false;
        }
        if (!haveLow(password))return false;
        if (!haveUp(password))return false;
        if (!haveDigit(password))return false;
        if (!haveOdd(password))return false;
        if (!con(password))return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "ziyS5FrPQhoQ5oEWRpHW2MjI7sGfcMJdcsjQnIyRbdCilvFaQN07jQtAkOklbjFrU5KcHzw4EvJ41Yz2Ykyd";
        String s2 = "!@#$%^&*()-+";
        String s1 = "09";
        System.out.println(strongPasswordCheckerII(s));
    }
}
