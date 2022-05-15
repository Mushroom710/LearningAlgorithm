package LeetCodeSpringRecruitment_2022.nine_week.day_seven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @DATE 2022/5/15
 * @TIME 21:09
 * @Created by zhangzhi
 * @description LeetCode 17 题 电话号码的字母组合
 * 回溯法抽象为树形结构后，其遍历过程就是：for循环横向遍历，递归纵向遍历，回溯不断调整结果集。
 * 如果大家在现场面试的时候，一定要注意各种输入异常的情况，例如本题输入1 * #按键
 */
public class LetterCombinationsOfAPhoneNumber {

    static List<String> ans;
    static StringBuffer s;

    static Map<Integer,String> map = new HashMap<>();
    public static void createMap(){
        map.put(0,"");
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
    }

    public static void backtracking(String digits,int idx){
        if (digits.length() == idx){// 如果 index 等于 输入的数字个数（digits.size）了
            ans.add(s.toString());
            return;
        }
        // 将 index 指向的数字转为 int
        int num = Character.digit(digits.charAt(idx),10);
        String letter = map.get(num); // 取数字对应的字符集
        for (int i = 0;i < letter.length();i++){
            s.append(letter.charAt(i));// 处理
            backtracking(digits,idx + 1);// 递归，注意index+1，一下层要处理下一个数字了
            s.deleteCharAt(s.length() - 1);// 回溯
        }

    }

    public static List<String> letterCombinations(String digits){
        if (digits.length() == 0)return new ArrayList<>();
        ans = new ArrayList<>();
        s = new StringBuffer();
        createMap();
        backtracking(digits,0);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2345"));
    }
}
