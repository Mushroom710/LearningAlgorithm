package LeetCodeSpringRecruitment_2022.second_week.day_one;

/**
 * @DATE 2022/3/21
 * @TIME 19:59
 * @Created by zhangzhi
 * @description LeetCode 67 题 二进制求和
 */
public class AddBinary {

    /**
     * @create zhangzhi
     * @date 2022/3/21
     * @time 20:08
     * @description 这种解法是可以的，但是单字符串很长的时候，就不适用了。
     */
    public static String solution(String a, String b) {
        long numA = Integer.parseInt(a, 2);
        long numB = Integer.parseInt(b, 2);

        return Integer.toBinaryString(Math.toIntExact(numA + numB));
    }

    public static String solution_two(String a, String b) {
        int a_size = a.length();
        int b_size = b.length();
        if (a_size > b_size) {
            b = '0' * (a_size - b_size) + b;
        } else if (a_size < b_size) {
            a = '0' * (b_size - a_size) + a;
        } else {

        }
        System.out.println(a);
        System.out.println(b);
        StringBuffer ans = new StringBuffer();
        int carry = 0;
        for (int i = a.length() - 1; i > 0; i--) {
            int sum = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            ans.append(sum % 2 + '0');
            carry = sum / 2;
        }
        if (carry > 0) {
            ans.append("1", 0, 1);
        }
        return String.valueOf(ans);
    }

    public static String solution_three(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(solution_two("11111001", "1111"));
    }
}
