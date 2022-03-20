package LeetCodeSpringRecruitment_2022.first_week;

/**
 * @DATE 2022/3/19
 * @TIME 21:12
 * @Created by zhangzhi
 * @description LeetCode 69 x的平方根
 */
public class Sqrt_x {

    /**
     * @create zhangzhi
     * @date 2022/3/19
     * @time 21:18
     * @description 这个题还要考虑到整型溢出的情况
     * 因为 0 <= x <= 2^31 - 1
     */
    public static int solution(int x){
        if(x < 2){
            return x;
        }
        long r = x;
        while (r > x / r){ // 在这个地方很容易出现整型溢出
            r = (r + x / r)/2;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }

}
