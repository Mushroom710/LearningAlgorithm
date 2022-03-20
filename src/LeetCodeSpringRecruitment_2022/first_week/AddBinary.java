package LeetCodeSpringRecruitment_2022.first_week;

/**
 * @DATE 2022/3/19
 * @TIME 21:06
 * @Created by zhangzhi
 * @description LeetCode 67 题 二进制求和
 */
public class AddBinary {

    /**
     * @create zhangzhi
     * @date 2022/3/19
     * @time 21:08
     * @description 先转成十进制，求和后再转成二进制
     */
    public static String solution(String a, String b){
        return Long.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    public static void main(String[] args) {

    }

}
