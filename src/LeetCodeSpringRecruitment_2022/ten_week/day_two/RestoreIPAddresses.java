package LeetCodeSpringRecruitment_2022.ten_week.day_two;

import java.util.ArrayList;
import java.util.List;

/**
 * @DATE 2022/5/17
 * @TIME 21:27
 * @Created by zhangzhi
 * @description LeetCode 93 题 复原 IP 地址
 * 切割问题就可以使用回溯搜索法把所有可能性搜出来
 * 终止条件和 131.分割回文串 情况就不同了，本题明确要求只会分成4段，所以不能用切割线切到最后作为终止条件，
 * 而是分割的段数作为终止条件。
 * pointNum表示逗点数量，pointNum为 3 说明字符串分成了 4 段了。
 * 然后验证一下第四段是否合法，如果合法就加入到结果集里
 */
public class RestoreIPAddresses {

    static List<String> ans;
    static int pointNum;

    /**
     * @create zhangzhi
     * @date 2022/5/17
     * @time 21:51
     * @description 判断字符串 s 在左闭又闭区间 [start, end] 所组成的数字是否合法
     */
    public static boolean isValid(String s,int start,int end){
        if (start > end)return false;
        // 有前导 0 --> 012 这种情况
        // 单个 0 的话，start == end
        if (s.charAt(start) == '0' && start != end)return false;
        int num = 0;
        for (int i = start; i <= end;i++){
            if (s.charAt(i) < '0' || s.charAt(i) > '9'){// 遇到非数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255){// 如果大于255了不合法
                return false;
            }
        }
        return true;
    }

    /**
     * @create zhangzhi
     * @date 2022/5/17
     * @time 21:51
     * @description startIndex: 搜索的起始位置，pointNum:添加逗点的数量
     */
    public static void backtracking(String s,int startIndex){
        if (pointNum == 3){// 逗点数量为3时，分隔结束
            // 判断第四段子字符串是否合法，如果合法就放进 ans 中
            if (isValid(s,startIndex,s.length() - 1)){
                ans.add(s);
            }
            return;
        }
        for (int i = startIndex;i < s.length();i++){
            if (isValid(s,startIndex,i)){// 判断 [startIndex,i] 这个区间的子串是否合法
                String str = s;
                // 因为 Java 的字符串是只读的，所以采用分割的方式在插入 .
                // 在i的后面插入一个逗点
                s = s.substring(0,i + 1) + "." + s.substring(i + 1);
                pointNum++;// 插入 . 后，pointNum 加 1
                // 插入逗点之后下一个子串的起始位置为i+2
                backtracking(s,i + 2);
                pointNum--;// 回溯
                s = str;// 回溯删掉逗点 --> 还原字符串
            }else {// 不合法，直接结束本层循环
                break;
            }
        }
    }

    public static List<String> restoreIpAddresses(String s){
        ans = new ArrayList<>();
        pointNum = 0;
        backtracking(s,0);
        return ans;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }
}
