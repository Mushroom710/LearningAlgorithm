package AutumnPlan_2023.April.day_4_15;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// @date 2023/4/15
// @time 22:30
// @author zhangzhi
// @description LeetCode 841. 钥匙和房间
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<Integer>();
        vis[0] = true;
        que.offer(0);
        while (!que.isEmpty()) {
            int x = que.poll();
            num++;
            for (int it : rooms.get(x)) {
                if (!vis[it]) {
                    vis[it] = true;
                    que.offer(it);
                }
            }
        }
        return num == n;
    }
}
