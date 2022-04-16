package LeetCodeSpringRecruitment_2022.five_week.day_five;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @DATE 2022/4/15
 * @TIME 21:49
 * @Created by zhangzhi
 * @description LeetCode 1047 删除字符串中的所有相邻重复项
 *
 * 本题要删除相邻相同元素，其实也是匹配问题，相同左元素相当于左括号，
 * 相同右元素就是相当于右括号，匹配上了就删除。
 *
 * 那么再来看一下本题：可以把字符串顺序放到一个栈中，
 * 然后如果相同的话 栈就弹出，这样最后栈里剩下的元素都是相邻不相同的元素了。
 */
public class RemoveAllAdjacentDuplicatesInString {

    /**
     * @create zhangzhi
     * @date 2022/4/15
     * @time 22:04
     * @description 这里的话，使用 Deque 作为堆栈
     */
    public static String solution(String s){
        Deque<Character> deque = new ArrayDeque<>();
        deque.addLast(s.charAt(0));
        for (int i = 0; i < s.length() - 1;i++){
            if (deque.isEmpty() || deque.peekLast() != s.charAt(i+1)){
                deque.addLast(s.charAt(i + 1));
            }else {
                deque.removeLast();
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()){
            ans.append(deque.removeFirst());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "abb";
        System.out.println(solution(s));
    }
}
