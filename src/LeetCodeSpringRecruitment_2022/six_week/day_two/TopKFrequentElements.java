package LeetCodeSpringRecruitment_2022.six_week.day_two;

import java.util.*;

/**
 * @DATE 2022/4/19
 * @TIME 21:22
 * @Created by zhangzhi
 * @description LeetCode 347 题   前 K 个高频元素
 * 这道题目主要涉及到如下三块内容：
 *  1.要统计元素出现频率
 *  2.对频率排序
 *  3.找出前 K 个高频元素
 *
 * 为什么要用小顶堆呢？
 *  因为要统计最大前 k 个元素，只有小顶堆每次将最小的元素弹出，
 *  最后小顶堆里积累的才是前k个最大元素。
 */
public class TopKFrequentElements {

    public static int[] solution(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[k];
        for (int num : nums){
            // map 有默认添加，如果这个 key 没有，可以给一个默认值
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        // Map类提供了一个称为entrySet()的方法，这个方法返回一个Map.Entry实例化后的对象集。
        // 接着，Map.Entry类提供了一个getKey()方法和一个getValue()方法
        // 也就是说，把 map 实例化为 Entry 后，就可以把 k-v 当做一个整体
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();

//      // 定义小顶堆
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(((o1, o2) -> o1.getValue() - o2.getValue()));
        for (Map.Entry<Integer,Integer> entry : entries){
            queue.offer(entry);
            // 小顶堆的 大小不能超过 k
            if (queue.size() > k){
                queue.poll();
            }
        }

        // 按照题目要求返回结果
        for (int i = k - 1; i >= 0;i--){
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(solution(nums,2)));
    }
}
