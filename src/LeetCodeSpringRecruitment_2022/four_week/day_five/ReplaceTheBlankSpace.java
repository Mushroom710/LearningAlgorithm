package LeetCodeSpringRecruitment_2022.four_week.day_five;

/**
 * @DATE 2022/4/8
 * @TIME 22:08
 * @Created by zhangzhi
 * @description 剑指 Offer 05. 替换空格
 * 其实很多数组填充类的问题，都可以先预先给数组扩容带填充后的大小，然后在从后向前进行操作。
 * 这么做有两个好处：
 *  不用申请新数组。
 *  从后向前填充元素，避免了从前先后填充元素要来的 每次添加元素都要将添加元素之后的所有元素向后移动
 */
public class ReplaceTheBlankSpace {

    /**
     * @create zhangzhi
     * @date 2022/4/8
     * @time 22:17
     * @description 先计算出字符串中的空格数
     * 然后再定义一个扩充后的字符数组
     * 用双指针从后往前遍历
     * 注意；因为空格本身就占一位，所以扩充计算数组大小时，需要 count*2，而不是 count*3
     */
    public static String solution(String s){
        if (s.length() <= 0){
            return s;
        }
        int count = 0;
        // 计算空格个数
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                count++;
            }
        }
        // 扩充数组 这里应该为 *2，而不是 *3，因为原来的空格就占一位
        char[] chs = new char[s.length() + count * 2];
        for(int i = 0;i < s.length();i++){
            chs[i] = s.charAt(i);
        }
        // 双指针，从后往前遍历
        for(int i = s.length() - 1,j = chs.length - 1; i >=0 ;i--,j--){
            if(chs[i] != ' '){
                chs[j] = chs[i];
            }else {
                chs[j - 2] = '%';
                chs[j - 1] = '2';
                chs[j] = '0';
                j -= 2;
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        String s = "we are h";
        System.out.println(solution(s));
    }
}
