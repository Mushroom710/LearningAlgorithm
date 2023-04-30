package AutumnPlan_2022.day_11_29;

// @date 2022/11/29
// @time 21:37
// @author zhangzhi
// @description LeetCode 剑指 Offer 05. 替换空格

public class LCOF {

    /**
     * 先统计空格个数。然后重新分配字符空间，把空格替换成 %20 即可。
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        int count = 0;
        // 统计空格个数
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        // 重新分配空间 因为 %20 是三个字符，而空格本身就占一个字符，所以分配多分配 2*count 的空间
        char[] chs = new char[s.length() + count * 2];
        int idx = 0;
        // 把空格替换成 %20
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chs[idx] = '%';
                chs[idx + 1] = '2';
                chs[idx + 2] = '0';
                idx += 3;
            } else {
                chs[idx] = s.charAt(i);
                idx++;
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
