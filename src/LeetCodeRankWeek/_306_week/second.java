package LeetCodeRankWeek._306_week;

// @DATE 2022/8/14
// @TIME 11:12
// @AUTHOR zhangzhi
// @DESCRIPTION 一定要注意数据范围！！！ -- 10^5

import java.util.HashMap;
import java.util.Map;

public class second {

    public static int edgeScore(int[] edges) {
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i],map.getOrDefault(edges[i],0L) + i);
        }
        long score = -1L;
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            if (entry.getValue() == score && entry.getKey() < min){
                min = entry.getKey();
            }else if (entry.getValue() > score){
                score = entry.getValue();
                min = entry.getKey();
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] edges = new int[]{0,2,2,9,9};
        System.out.println(edgeScore(edges));
    }
}
