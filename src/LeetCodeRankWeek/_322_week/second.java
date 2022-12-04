package LeetCodeRankWeek._322_week;

// @date 2022/12/4
// @time 10:25
// @author zhangzhi
// @description

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class second {

    public static long dividePlayers(int[] skill) {
        long all_sum = 0;
        for(int nums : skill){
            all_sum += nums;
        }
        int len = skill.length;
        int group = len / 2;
        if(all_sum % group != 0){
            return -1;
        }
        Long skills = all_sum / group;
        Map<Long,Integer> map = new HashMap<>();
        long sum = 0;
        for(int i = 0; i < len; i++){
            if(map.containsKey((long)skill[i])){
                int num = map.get((long)skill[i]);
                sum = sum + (long) num * skill[i];
                map.remove((long)skill[i],num);
            }else {
                map.put(skills - skill[i], skill[i]);
            }
        }
        if(!map.isEmpty()){
            return -1;
        }
        return sum;
    }

    public static long solution(int[] skill){
        long all_sum = 0;
        for(int nums : skill){
            all_sum += nums;
        }
        int len = skill.length;
        int group = len / 2;
        if(all_sum % group != 0){
            return -1;
        }
        Long skills = all_sum / group;
        Arrays.sort(skill);
        long sum = 0;
        for(int i = 0,j = len - 1; i < j; i++,j--){
            if(skill[i] + skill[j] != skills){
                return -1;
            }else{
                sum += (long) skill[i] * skill[j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] skill = new int[]{3,4};
//        System.out.println(dividePlayers(skill));
        System.out.println(solution(skill));
    }
}
