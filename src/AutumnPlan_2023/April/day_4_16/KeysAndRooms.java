package AutumnPlan_2023.April.day_4_16;

// @date 2023/4/16
// @time 8:18
// @author zhangzhi
// @description LeetCode 841. 钥匙和房间
// 可以用深度搜索和广度搜索

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] bool = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = rooms.get(0);
        bool[0] = true;
        // 第 0 间房子可以直接访问
        for(int i = 0; i < list.size(); i++){
            // 把第 0 间房子包含的钥匙加入队列
            queue.add(list.get(i));
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                // 拿到一把钥匙
                int key = queue.poll();
                // 打开这把钥匙对应的房间
                list = rooms.get(key);
                // 这把钥匙对应的房间置为 true
                bool[key] = true;
                for(int j = 0; j < list.size(); j++){
                    // 遍历这个房间的钥匙，如果对应的钥匙已经打开过对应的房间，跳过
                    if(!bool[list.get(j)]){
                        // 否则加入钥匙队列
                        queue.add(list.get(j));
                    }
                }
            }
        }
        // 最后遍历整个 bool 数组，检查有没有房间未被访问过
        for(int i = 0; i < n; i++){
            if(!bool[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(new ArrayList<>());
        System.out.println(canVisitAllRooms(rooms));

    }
}
