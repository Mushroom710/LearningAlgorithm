package LeetCodeSpringRecruitment_2022.four_week.day_two;

import java.util.HashMap;
import java.util.Map;

/**
 * @DATE 2022/4/5
 * @TIME 21:48
 * @Created by zhangzhi
 * @description LeetCode 454 题 四数相加 II
 */
public class _4SumII {

    /**
     * @create zhangzhi
     * @date 2022/4/5
     * @time 21:58
     * @description
     * 首先定义 一个unordered_map，key放a和b两数之和，value 放a和b两数之和出现的次数。
     * 1.遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
     * 2.定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
     * 3.在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
     * 4.最后返回统计值 count 就可以了
     */
    public static int solution(int[] nums1,int[] nums2,int[] nums3,int[] nums4){
        Map<Integer,Integer> map = new HashMap<>();
        for(int v1 : nums1){
            for(int v2 : nums2){
                if(map.containsKey(v1 + v2)){
                   map.put(v1 + v2,map.get(v1 + v2) + 1);
                }else {
                    map.put(v1 + v2,1);
                }
            }
        }
        int count = 0;
        for(int v3 : nums3){
            for (int v4 : nums4){
                if(map.containsKey(-(v3+v4))){
                    count += map.get(-(v3+v4));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{-2,-1};
        int[] nums3 = new int[]{-1,2};
        int[] nums4 = new int[]{0,2};
        System.out.println(solution(nums1,nums2,nums3,nums4));
    }
}
