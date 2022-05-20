package LeetCodeSpringRecruitment_2022.ten_week.day_five;

import java.util.*;

/**
 * @DATE 2022/5/20
 * @TIME 21:23
 * @Created by zhangzhi
 * @description LeetCode 322 题 重新安排行程
 * 难点：
 *  1.一个行程中，如果航班处理不好容易变成一个圈，成为死循环
 *  2.有多种解法，字母序靠前排在前面，让很多同学望而退步，如何该记录映射关系呢 ？
 *  3.使用回溯法（也可以说深搜） 的话，那么终止条件是什么呢？
 *  4.搜索的过程中，如何遍历一个机场所对应的所有机场。
 */
public class ReconstructItinerary {

    static Map<String, Map<String,Integer>> map;// 映射表
    static Deque<String> ans;// answer
    public static boolean backtracking(int ticketNum){
        // 找到一条路径就返回
        if (ans.size() == ticketNum + 1){
            return true;
        }
        String pre = ans.getLast();
        // 出发机场和到达机场也会重复的，如果在解题的过程中没有对集合元素处理好，就会死循环。
        // 会出现空指针的问题
        if (map.containsKey(pre)) {
            for (Map.Entry<String, Integer> entry : map.get(pre).entrySet()) {
//            int count = entry.getValue();
                // 如果“航班次数”大于零，说明目的地还可以飞，如果如果“航班次数”等于零说明目的地不能飞了，而不用对集合做删除元素或者增加元素的操作
                if (entry.getValue() > 0) {
                    ans.add(entry.getKey());
                    // 可以使用"航班次数"这个字段的数字做相应的增减，来标记到达机场是否使用过了
                    entry.setValue(entry.getValue() - 1);
                    if (backtracking(ticketNum)) return true;
                    ans.removeLast();
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }
        return false;
    }
    public static List<String> findItinerary(List<List<String>> tickets){
        map = new HashMap<>();
        ans = new LinkedList<>();
        for (List<String> list : tickets){
            Map<String,Integer> temp;
            if (map.containsKey(list.get(0))){
                temp = map.get(list.get(0));
                temp.put(list.get(1),temp.getOrDefault(list.get(1),0) + 1);
            }else {
                // 用 TreeMap 生成按字典序排序的集合
                temp = new TreeMap<>();
                temp.put(list.get(1),1);
            }
            map.put(list.get(0),temp);
        }
        ans.push("JFK");// 初始机场必须是 JFK
        backtracking(tickets.size());
        return new LinkedList<>(ans);
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        String[][] des = new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        for (String[] s : des){
            List<String> temp = new ArrayList<>();
            temp.add(s[0]);
            temp.add(s[1]);
            list.add(new ArrayList<>(temp));
        }
        System.out.println(findItinerary(list));
    }
}
