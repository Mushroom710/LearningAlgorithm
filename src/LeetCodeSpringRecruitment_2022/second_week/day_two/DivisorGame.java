package LeetCodeSpringRecruitment_2022.second_week.day_two;

/**
 * @DATE 2022/3/22
 * @TIME 15:23
 * @Created by zhangzhi
 * @description
 */
public class DivisorGame {
    /**
     * @create zhangzhi
     * @date 2022/3/22
     * @time 15:26
     * @description 大佬的题解。妙啊！
     * 1.数字N如果是奇数，它的约数必然都是奇数；若为偶数，则其约数可奇可偶。
     * 2.无论N初始为多大的值，游戏最终只会进行到N=2时结束，那么谁轮到N=2时谁就会赢。
     * 3.因为爱丽丝先手，N初始若为偶数，爱丽丝则只需一直选1，使鲍勃一直面临N为奇数的情况，这样爱丽丝稳赢；
     *  N初始若为奇数，那么爱丽丝第一次选完之后N必为偶数，那么鲍勃只需一直选1就会稳赢。
     * 4.综述，判断N是奇数还是偶数，即可得出最终结果！
     */
    public static boolean solution(int n){
        return (n&1)==0;
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
    }
}
