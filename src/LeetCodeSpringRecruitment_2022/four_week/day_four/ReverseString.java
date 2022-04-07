package LeetCodeSpringRecruitment_2022.four_week.day_four;

/**
 * @DATE 2022/4/7
 * @TIME 21:51
 * @Created by zhangzhi
 * @description LeetCode 344 反转字符串
 *
 * 如果在现场面试中，我们什么时候使用库函数，什么时候不要用库函数呢？
 *  如果题目关键的部分直接用库函数就可以解决，建议不要使用库函数。
 *
 * 毕竟面试官一定不是考察你对库函数的熟悉程度， 如果使用python和 java 的同学更需要注意这一点，
 * 因为python、java提供的库函数十分丰富
 *
 *  如果库函数仅仅是 解题过程中的一小部分，
 *  并且你已经很清楚这个库函数的内部实现原理的话，可以考虑使用库函数。
 */
public class ReverseString {

    /**
     * @create zhangzhi
     * @date 2022/4/7
     * @time 21:57
     * @description 思路很简单：
     * 使用双指针，一前一后，交换字符，然后同时收缩
     */
    public static void solution(char[] s){
        for(int i = 0, j = s.length - 1; i < s.length / 2; i++,j--){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','k','l','o'};
        solution(s);
        System.out.println(s);
    }
}
