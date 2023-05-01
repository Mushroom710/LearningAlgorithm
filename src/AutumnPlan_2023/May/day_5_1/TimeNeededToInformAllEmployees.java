package AutumnPlan_2023.May.day_5_1;

import java.util.*;

// @date 2023/5/1
// @time 11:18
// @author zhangzhi
// @description LeetCode 每日一题 1376. 通知所有员工所需的时间
// 抽象树的建立
// 题目意思很明确，就是找出每一层的最大 time，相加就是答案。
// 但是难点就是，怎么表示这种关系，所以需要建树，但是怎么建树，又是一个难点。
// 其实建树这个过程我已经写出来了，但是没有更深层次的思考，只能说没有做过这种题，很难想到。
public class TimeNeededToInformAllEmployees {

    private static int dfs2(Map<Integer, List<Integer>> map, int[] informTime, int headID){
        int time = 0;
        List<Integer> list = map.get(headID);
        if(list != null){
            for(int num : list){
                time = Math.max(time, dfs2(map, informTime, num));
            }
        }
        return time + informTime[headID];
    }

    public static int bfs(Map<Integer, List<Integer>> map, int[] manager, int[] informTime){
        int ans = 0;
        Deque<List<Integer>> queue = new ArrayDeque<>();
        queue.add(map.get(-1));
        while(!queue.isEmpty()){
            int size = queue.size();
            int time = 0;
            for(int i = 0; i < size; i++){
                List<Integer> list = queue.poll();
                //time = informTime[list.get(0)];
                for (int num : list){
                    time = Math.max(time, informTime[num]);
                    if(map.get(manager[num]) != null){
                        queue.add(map.get(manager[num]));
                        map.remove(manager[num]);
                    }
                }
            }
            ans += time;
        }
        return ans;
    }
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // 这个操作我也想到了，但是如果进一步抽象，这就是建一般树的过程。
        // 所以，要找出每一层的最大 time，就是遍历这颗一般树。
        // 这个操作，就是建树
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < manager.length; i++){
            if(map.containsKey(manager[i])){
                List<Integer> list = map.get(manager[i]);
                list.add(i);
                map.put(manager[i], list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(manager[i], list);
            }
        }
        return bfs(map, manager,informTime);
    }

    // 思路就是树的遍历，但是我不会建树
    // 灵茶的这种建树方式确实头一次见
    public int numOfMinutes2(int n, int headID, int[] manager, int[] informTime) {
        List<Integer> g[] = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n; ++i)
            if (manager[i] >= 0)
                g[manager[i]].add(i); // 建树
        return dfs(g, informTime, headID); // 从根节点 headID 开始递归
    }

    private int dfs(List<Integer>[] g, int[] informTime, int x) {
        int maxPathSum = 0;
        for (int y : g[x]) // 遍历 x 的儿子 y（如果没有儿子就不会进入循环）
            maxPathSum = Math.max(maxPathSum, dfs(g, informTime, y));
        // 这和 104 题代码中的 return max(lDepth, rDepth) + 1; 是一个意思
        return maxPathSum + informTime[x];
    }

    public static void main(String[] args) {
        int n = 6;
        int headId = 2;
        int[] manager = new int[]{2,2,-1,2,2,2};
        int[] informTime = new int[]{0,0,1,0,0,0};
        System.out.println(numOfMinutes(n, headId, manager, informTime));
    }
}
