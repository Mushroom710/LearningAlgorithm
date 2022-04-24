package oj.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @DATE 2022/4/24
 * @TIME 15:06
 * @Created by zhangzhi
 * @description
 */
public class second {

    public static int solution(int[] arr, int n, int m){
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n;i++){
            if (map.get(arr[i]) == null){
                map.put(m - arr[i],i);
            }else {
                map.put(m - arr[i],i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(solution(arr,3,9));
    }
}
