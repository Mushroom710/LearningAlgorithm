package AutumnPlan_2023.March.day_3_24;

// @date 2023/3/24
// @time 22:05
// @author zhangzhi
// @description LeetCode 347. 前 K 个高频元素

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    /**
     * 基于小顶堆实现
     */
    public int[] topKFrequent(int[] nums, int k) {
        // key为数组元素值,val为对应出现次数
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
        }
        // 在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        // 出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){// 小顶堆只需要维持k个元素有序
            if(pq.size() < k){ // 小顶堆元素个数小于k个时直接加
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }else{
                if(pq.peek()[1] < entry.getValue()){ // 当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                    pq.poll(); // 弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--){ // 依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
