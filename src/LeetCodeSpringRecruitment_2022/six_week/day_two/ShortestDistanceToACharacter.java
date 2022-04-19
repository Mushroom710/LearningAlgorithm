package LeetCodeSpringRecruitment_2022.six_week.day_two;

import java.util.Arrays;

/**
 * @DATE 2022/4/19
 * @TIME 22:09
 * @Created by zhangzhi
 * @description LeetCode 821 题 字符的最短距离
 */
public class ShortestDistanceToACharacter {

    public static int[] solution(String s,char c){
        int[] ans = new int[s.length()];
        // 找两边出现的第一个 c 是为了处理 类似于 "aabaa" 这种情况
        int idx = 0;
        // 找左边出现的第一个 c
        while (s.charAt(idx) !=  c){
            idx++;
        }
        ans[idx] = 0;
        for (int i = 0; i < idx;i++){
            ans[i] = idx - i;
        }
        // 找右边出现的第一个 c
        int idx_right = s.length() - 1;
        while (s.charAt(idx_right) != c){
            idx_right--;
        }
        ans[idx_right] = 0;
        for (int i = idx_right + 1; i < s.length();i++){
            ans[i] = i - idx_right;
        }

        for (int i = idx; i < idx_right;i++){
            if (s.charAt(i) == c){
                ans[i] = 0;
                continue;
            }
            int left = i;
            int right = i;
            // 找左边的最近的 c 注意不能越界
            while (left >idx && s.charAt(left) != c){
                left--;
            }
            // 找右边最近的 c
            while (right < idx_right &&s.charAt(right) != c){
                right++;
            }
            // 计算绝对值的最小值
            ans[i] = Math.min(Math.abs(left - i),Math.abs(right - i));
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abaa";
        System.out.println(Arrays.toString(solution(s,'b')));
    }
}
