package LeetCodeSpringRecruitment_2022.eleven_week.day_one;

import java.util.Arrays;

/**
 * @DATE 2022/5/23
 * @TIME 21:17
 * @Created by zhangzhi
 * @description LeetCode 455 题 分发饼干
 * 贪心法：
 *  这里的局部最优就是大饼干喂给胃口大的，充分利用饼干尺寸喂饱一个，全局最优就是喂饱尽可能多的小孩。
 *  可以尝试使用贪心策略，先将饼干数组和小孩数组排序。
 *  然后从后向前遍历小孩数组，用大饼干优先满足胃口大的，并统计满足小孩数量。
 *  同样，也可以用小饼干优先满足胃口小的
 */
public class AssignCookies {

    /**
     * @create zhangzhi
     * @date 2022/5/23
     * @time 21:23
     * @description 优先满足胃口大的
     */
    public static int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int s_index = s.length - 1;
        int count = 0;
        for (int i = g.length - 1;i >= 0; i--){
            if (s_index >= 0 && s[s_index] >= g[i]){
                count++;
                s_index--;
            }
        }
        return count;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/23
     * @time 21:27
     * @description 优先满足胃口小的
     */
    public static int findContentChildren_small(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int g_index = 0;
        for (int i = 0; i < s.length;i++){
            if (g_index < g.length && g[g_index] <= s[i]){
                g_index++;
            }
        }
        return g_index;
    }
    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        System.out.println(findContentChildren(g,s));
    }
}
