package LeetCode;

import java.util.*;

/**
 * @DATE 2022/2/27
 * @Created by zhangzhi
 * @description 滑动窗口中的最大值
 * 1.用优先队列解决，本质是大顶堆
 * 2.用一个双端队列，本质是单调队列
 */
public class slidingWindowMaximum {

    /**
     * @return a
     * @create zhangzhi
     * @date 2022/2/27
     * @time 17:30
     * @description 单调队列解决
     */
    public static int[] solution(int[] nums,int k){
        if(nums.length<2){
            return nums;
        }
        Deque<Integer> dq = new ArrayDeque<>();//双端队列
        int[] result = new int[nums.length - k + 1];//数组大小为窗口的个数加1
        int idx = 0;//记录result数组的下标
        for(int i = 0;i<nums.length;i++){
            if((i-k)>=0&&!dq.isEmpty() && nums[i-k] == dq.peekFirst()){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && dq.peekLast() < nums[i]){
                dq.removeLast();
            }
            dq.offerLast(nums[i]);
            if(i>=k-1){
                result[idx++] = dq.peekFirst();
            }
        }
        return result;
    }

    /**
     * @param
     * @return a
     * @create zhangzhi
     * @date 2022/2/27
     * @time 17:33
    * @description 优先队列初始化为大根堆
     * 提交LeetCode超时了。。。
     */
    public static int[] solution_second(int[] nums,int k){
        if(nums.length<2){
            return nums;
        }
        //初始化为大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        int idx = 0;
        for(int i=0;i<k;i++){
            maxHeap.offer(nums[i]);
        }
        result[idx++] = maxHeap.peek();
        for(int i=k;i<nums.length;i++){
            maxHeap.remove(nums[i-k]);
            maxHeap.offer(nums[i]);
            result[idx++] = maxHeap.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(solution(nums,3)));
        System.out.println(Arrays.toString(solution_second(nums,3)));
    }
}
