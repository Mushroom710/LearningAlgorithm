package LeetCodeRankWeek._291_week;

import java.util.HashMap;
import java.util.Map;

/**
 * @DATE 2022/5/1
 * @TIME 10:50
 * @Created by zhangzhi
 * @description
 */
public class second {

    public static int solution(int[] cards){
        int min = cards.length;
        for (int i = 0;i < cards.length - 1;i++){
            for (int j = i + 1; j < cards.length;j++){
                if (cards[j] == cards[i]){
                    min = Math.min(min,j - i + 1);
                    break;
                }
            }
        }
        if (min == cards.length){
            return -1;
        }
        return min;
    }

    public static int solution_two(int[] cards){
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < cards.length;i++){
            if (map.get(cards[i]) != null) {
                min = Math.min(i - map.get(cards[i]) + 1, min);
            }
            map.put(cards[i],i);
        }
        if (min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] cards = new int[]{0,0};
        System.out.println(solution(cards));
        System.out.println(solution_two(cards));
    }
}
