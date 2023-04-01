package AutumnPlan_2023.March.day_3_22;

// @date 2023/3/22
// @time 21:42
// @author zhangzhi
// @description LeetCode 1047. 删除字符串中的所有相邻重复项

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(!deque.isEmpty() && deque.peekLast() == s.charAt(i)){
                deque.pollLast();
                continue;
            }
            deque.addLast(s.charAt(i));
        }
        StringBuffer sb = new StringBuffer(deque.size());
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}
