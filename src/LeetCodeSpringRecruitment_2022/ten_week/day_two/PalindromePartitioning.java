package LeetCodeSpringRecruitment_2022.ten_week.day_two;

import java.util.ArrayList;
import java.util.List;

/**
 * @DATE 2022/5/17
 * @TIME 20:39
 * @Created by zhangzhi
 * @description LeetCode 131 题 分割回文串
 * 其实切割问题类似组合问题。
 * 例如对于字符串 abcdef：
 *  1.组合问题：选取一个 a 之后，在 bcdef 中再去选取第二个，选取 b 之后在 cdef 中在选组第三个.....。
 *  2.切割问题：切割一个 a 之后，在 bcdef 中再去切割第二段，切割 b 之后在 cdef 中在切割第三段.....。
 */
public class PalindromePartitioning {

    static List<List<String>> ans;
    static List<String> path;

    /**
     * @create zhangzhi
     * @date 2022/5/17
     * @time 21:11
     * @description 判断是不是回文字符串 --> 双指针法判定
     */
    public static boolean isPalindrome(String s,int start,int end){
        for (int i = start,j = end; i < j;i++,j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/17
     * @time 21:11
     * @description
     * 本题递归函数参数还需要startIndex，因为切割过的地方，不能重复切割，和组合问题也是保持一致的
     */
    public static void backtracking(String s,int startIndex){
        // 如果起始位置已经大于s的大小，说明已经找到了一组分割方案了
        if (startIndex >= s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex;i < s.length();i++){
            if (isPalindrome(s,startIndex,i)){// 判定子串是不是回文串，不是就跳过本次循环
                // 获取[startIndex,i]在s中的子串
                String str = s.substring(startIndex,i + 1);
                path.add(str);
            }else {
                continue;
            }
            backtracking(s,i + 1);// 寻找i+1为起始位置的子串
            path.remove(path.size() - 1);// 回溯
        }
    }

    public static List<List<String>> partition(String s){
        ans = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(s,0);
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabaaa";
        System.out.println(partition(s));
    }
}
