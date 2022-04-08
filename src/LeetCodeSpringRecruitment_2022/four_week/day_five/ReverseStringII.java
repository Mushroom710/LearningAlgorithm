package LeetCodeSpringRecruitment_2022.four_week.day_five;

/**
 * @DATE 2022/4/8
 * @TIME 21:12
 * @Created by zhangzhi
 * @description LeetCode 541 题 反转字符串 II
 *
 * 说的正是在下：（哈哈哈）
 *     一些同学可能为了处理逻辑：每隔2k个字符的前k的字符，
 *     写了一堆逻辑代码或者再搞一个计数器，来统计2k，再统计前k个字符。
 */
public class ReverseStringII {

    // 反转字符数组
    private static void reverse(char[] chs,int left,int right){
        for(int i = left,j = right;i < j;i++,j--){
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }
    }

    /**
     * @create zhangzhi
     * @date 2022/4/8
     * @time 21:53
     * @description 写了一堆逻辑，没通过。。。
     */
    public static String solution(String s,int k){
        int len = s.length();
        int count = len / k - 1;
        int diff = len - count * 2 * k;
        int i = 0;
        int idx = 0;
        char[] chs = s.toCharArray();
        while (i < count){
            reverse(chs,idx,idx + k - 1);
            idx += 2 * k;
            i++;
        }

        if(diff < k){
            reverse(chs,len - diff - 1,len - 1);
        }
        if(diff < 2 * k && diff >= k){
            reverse(chs,len - diff - 1,len - k - 1);
        }
        return new String(chs);
    }

    /**
     * @create zhangzhi
     * @date 2022/4/8
     * @time 21:53
     * @description 模拟题的本质就是在限定的条件中完成即可
     * 这道题目其实也是模拟，实现题目中规定的反转规则就可以了。
     * 其实在遍历字符串的过程中，只要让 i += (2 * k)，
     * i 每次移动 2 * k 就可以了，然后判断是否需要有反转的区间。
     *
     * 所以当需要固定规律一段一段去处理字符串的时候，要想想在在for循环的表达式上做做文章。
     */
    public static String solution_two(String s,int k){
        char[] chs = s.toCharArray();
        int len = s.length();
        int i = 0;
        // 每次移动 2*k 即可
        while (i < len && len - i > k){
            reverse(chs,i,i + k - 1);
            i += (2 * k);
        }
        // 剩余字符不足 k 个
        if(len - i < k){
            reverse(chs,i,len - 1);
        }else if(i + k <= len){// 剩余字符 k<= count < 2*k
            reverse(chs,i,i + k - 1);
        }
        return new String(chs);
    }

    /**
     * @create zhangzhi
     * @date 2022/4/8
     * @time 21:55
     * @description 对上面的一种优雅写法
     */
    public static String solution_three(String s,int k){
        char[] chs = s.toCharArray();
        for(int i = 0; i < s.length();i += 2 * k){
            if(i + k <= s.length()){
                reverse(chs,i,i + k -1);
                continue;
            }
            reverse(chs,i,s.length() - 1);
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        String s = "abcdefghi";
//        System.out.println(solution(s,2));
//        System.out.println(solution_two(s,3));
        System.out.println(solution_three(s,3));
    }
}
