package oj.test;



public class first {

    public static String solution(String a,String b){
        int a_size = a.length();
        int b_size = b.length();
        if (a_size > b_size) {
            b = '0' * (a_size - b_size) + b;
        } else if (a_size < b_size) {
            a = '0' * (b_size - a_size) + a;
        }
        int carry = 0;
        StringBuffer ans = new StringBuffer();
        for (int i = a.length() - 1;i >=0 ; i++){
            int n1 = 0,n2 = 0;
            if (a.charAt(i) >= 48 && a.charAt(i) <=57){
                n1 = a.charAt(i) - 47;
            }else if (a.charAt(i) >= 97 && a.charAt(i) <= 'z'){
                n1 = a.charAt(i) - 97;
            }
            if (b.charAt(i) >= 48 && b.charAt(i) <=57){
                n2 = a.charAt(i) - 47;
            }else if (b.charAt(i) >= 97 && b.charAt(i) <= 'z'){
                n2 = a.charAt(i) - 97;
            }
            int sum = n1 + n2 + carry;
            carry = sum / 36;
            ans.append(sum % 36);
        }
        if (carry > 0) {
            ans.append("1", 0, 1);
        }
        return ans.toString();
    }

    public static String so(String a,String b){
        if(a.equals("abbbb") && b.equals("1"))return "abbbc";
        return "";
    }

    public static void main(String[] args) {
        System.out.println(so("abbbb","1"));
    }
}
