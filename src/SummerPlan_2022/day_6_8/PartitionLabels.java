package SummerPlan_2022.day_6_8;

import java.util.ArrayList;
import java.util.List;

/**
 * @DATE 2022/6/8
 * @TIME 10:34
 * @Created by zhangzhi
 * @description LeetCode 763 题 划分字母区间
 * 通过字符出现最远距离取并集的方法，把出现过的字符都圈到一个区间里。
 */
public class PartitionLabels {

    /**
     * @create zhangzhi
     * @date 2022/6/8
     * @time 10:41
     * @description
     * 在遍历的过程中相当于是要找每一个字母的边界，如果找到之前遍历过的所有字母的最远边界，
     * 说明这个边界就是分割点了。此时前面出现过所有字母，最远也就到这个边界了。
     * 可以分为如下两步：
     *  1.统计每一个字符最后出现的位置
     *  2.从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，
     *    则找到了分割点
     */
    public static List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] edge = new int[26];
        char[] chs = s.toCharArray();
        for (int i = 0;i < chs.length;i++){// 统计每一个字符最后出现的位置
            edge[chs[i] - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        for (int i = 0;i < s.length();i++){
            right = Math.max(right,edge[chs[i] - 'a']);// 找到字符出现的最远边界
            if (i == right){// 最远边界和当前边界相等，找到一个分割点
                list.add(right - left + 1);
                left = i + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
