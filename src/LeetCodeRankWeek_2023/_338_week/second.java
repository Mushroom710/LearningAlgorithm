package LeetCodeRankWeek_2023._338_week;

// @date 2023/3/26
// @time 10:17
// @author zhangzhi
// @description

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class second {

    static class SimpleStack{
        Deque<Integer> deque;
        Deque<Integer> tmp;
        public SimpleStack(){
            this.deque = new LinkedList<>();
            this.tmp = new LinkedList<>();
        }
        public boolean add(int num){
            if(deque.isEmpty() || deque.peekLast() < num){
                deque.addLast(num);
                while(!tmp.isEmpty()){
                    deque.addLast(tmp.pollLast());
                }
            }else if(deque.peekLast() >= num){
                while(!deque.isEmpty() && deque.peekLast() >= num){
                    tmp.addLast(num);
                    int last = deque.pollLast();
                    for(int i = 1; i <= last; i++){
                        if(isPrime(i)){
                            if(last - i < 1){
                                return false;
                            }
                            if(last - i < num){
                                return add(last - i);
                            }
                        }
                    }
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean primeSubOperation(int[] nums) {
        SimpleStack simpleStack = new SimpleStack();
        for(int i = 0; i < nums.length; i++){
            if(!simpleStack.add(nums[i])){
                return false;
            }
        }
        return true;
    }

    public static boolean primeSubOperation2(int[] nums) {
        int len = nums.length - 2;
        for(int i = len; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                continue;
            }

            while(true){
                int tmp = nums[i];
                for(int j = 1; j <= nums[i]; j++){
                    if(isPrime(j)){
                        if(nums[i] - j < 1){
                            return false;
                        }
                        if(nums[i] - j < nums[i + 1]){
                            nums[i] = nums[i] - j;
                            break;
                        }
                    }
                }
                if(nums[i] == tmp){
                    return false;
                }
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{16,8,4};
        System.out.println(primeSubOperation2(nums));
    }
}
