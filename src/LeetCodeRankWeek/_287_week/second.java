package LeetCodeRankWeek._287_week;

import java.util.*;

/**
 * @DATE 2022/4/3
 * @TIME 11:27
 * @Created by zhangzhi
 * @description LeetCode 5235 找出输掉零场或一场比赛的玩家
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri]
 * 表示在一场比赛中 winneri 击败了 loseri 。
 * 返回一个长度为 2 的列表 answer ：
 *      answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 *      answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 * 注意：
 *      只考虑那些参与 至少一场 比赛的玩家。
 *      生成的测试用例保证 不存在 两场比赛结果 相同 。
 */
public class second {


    /**
     * @create zhangzhi
     * @date 2022/4/3
     * @time 11:59
     * @description 巧妙使用数据结构来辅助解题
     * 思路：用一个 winMap 统计获胜的人，用 loseMap 统计失败的人
     * 用一个 set 记录失败的人，这个 set 最后用来查找那些没有失败的人
     */
    public static List<List<Integer>> solution(int[][] matchs){
        int len = matchs.length;
        Map<Integer,Integer> win = new HashMap<>(); // 获胜者的获胜次数
        Map<Integer,Integer> lose = new HashMap<>(); // 失败者的失败次数
        Set<Integer> loseSet = new HashSet<>(); // 失败者 集合
        for(int i = 0; i < len; i++){ // 统计获胜次数和失败次数
            // 初始时：map 里可能没有对应的 key ，所以这里运用了三目运算符来判断
            // 是否有对应的 key，有就 +1，没有的话，直接给 1
            win.put(matchs[i][0],win.get(matchs[i][0]) == null ? 1 : win.get(matchs[i][0]));
            lose.put(matchs[i][1],lose.get(matchs[i][1]) == null ? 1 : lose.get(matchs[i][1]) + 1);
            loseSet.add(matchs[i][1]); // 把失败的人加入失败者集合
        }

        List<Integer> loseList = new ArrayList<>();// 只失败一次的列表

        for(int key : lose.keySet()){ // 遍历失败者 map
            if(lose.get(key) == 1){ // 找出只失败一次的人
                loseList.add(key); // 加入列表
            }
        }
//        System.out.println(loseList);
        List<Integer> winList = new ArrayList<>(); // 一次也没有失败的人
        for(int key : win.keySet()){ //遍历获胜者 map
            if(loseSet.add(key)){ // 查看失败者集合里有没有，有说明这个获胜者至少失败了一次
                winList.add(key);// 把一次也没有失败的人加入列表
            }
        }
//        System.out.println(winList);
        Collections.sort(loseList);//对两个列表按递增排序
        Collections.sort(winList);
        List<List<Integer>> ans = new ArrayList<>();// 结果列表
        ans.add(winList);
        ans.add(loseList);
        return ans;
    }

    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> ans = solution(matches);
        System.out.println(ans.get(0));
        System.out.println(ans.get(1));
    }
}
