package LeetCodeRankWeek._293_week;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @DATE 2022/5/15
 * @TIME 10:29
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static List<String> removeAnagrams(String[] words) {
        List<String> list = new LinkedList<>(Arrays.asList(words));
        for (int i = 1;i < list.size();){
            char[] chs1 = list.get(i).toCharArray();
            Arrays.sort(chs1);
            char[] chs2 = list.get(i - 1).toCharArray();
            Arrays.sort(chs2);
            String s1 = new String(chs1);
            String s2 = new String(chs2);
            if (s1.equals(s2)){
                list.remove(i);
            }else {
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
