package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @DATE 2022/3/1
 * @Created by zhangzhi
 * @description LeetCode 15题 三数之和
 * 这个题是两数之和的变式
 * 1.直接暴力求解，三重循环判断
 * 2.优化。因为 x+y+z=0，所以 z = -(x+y)
 * 这时候，只需要查找数组中有没有 z 即可
 * 3.新奇解法
 *  a.先排序
 *  b.枚举 a，从剩下的子数组中找 b和 c
 *  b从前找，c从后找
 *  if a+b+c > 0 => c--
 *  if a+b+c < 0 => b++
 *  还得注意去除重复的元素
 */
public class threeSum {

    //错误编码
    public static List<List<Integer>> solution(int[] nums){
        if(nums.length<2) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int b,c;
        for(int i = 0;i<nums.length-2;i++){
            if(i>0&&nums[i] == nums[i-1])continue;//需要和上一次枚举的不同
            b = i+1;
            c = nums.length-1;
            while (b<c){
                if (b>i+1&&nums[b] == nums[b-1]){
                    b++;
                    continue;
                }

                while(b<c&&nums[i]+nums[b]+nums[c]>0){
                    c--;
                }
                while(b<c&&nums[i]+nums[b]+nums[c]<0){
                    b++;
                }
                if(b == c) {
                    break;
                }else if(nums[i]+nums[b]+nums[c] == 0){
                    ArrayList<Integer> relist = new ArrayList<>();
                    relist.add(nums[i]);
                    relist.add(nums[b]);
                    relist.add(nums[c]);
                    list.add(relist);
                }
                b++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        System.out.println(solution(nums));
    }

}
