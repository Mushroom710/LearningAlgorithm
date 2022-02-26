package GeekTime.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @DATE 2022/2/26
 * @Created by zhangzhi
 * @description 返回数据流中第 k 大数据元素
 * 思路：使用优先队列。维护一个小顶堆，堆的 size 为 k
 * 每次与数据流的元素比较大小，若大于小顶堆，拿掉最上面的元素，添加新的元素进小顶堆
 */

//第 k 大元素类
class KthLargest {

    final PriorityQueue<Integer> pq;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for(int num:nums){
            add(num);
        }
    }

    public int add(int val) {
        if(pq.size()<k){
            pq.offer(val);
        }else if(pq.peek()<val){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

public class leetcode703 {

    static PriorityQueue<Integer> pq;
    static int k;//第 k 大数据元素，用于初始化小顶堆的size

    public static int[] CreateArr(){
        int max = 100;
        int size = (int)(Math.random()*max);
        System.out.println("数组大小为:"+size);
        int[] arr = new int[size];
        for(int i = 0;i<size;i++){
            arr[i] = (int)(Math.random()*max);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = CreateArr();
        int k = 3;
        KthLargest kth = new KthLargest(k,nums);
        System.out.println(kth.pq.peek());
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
