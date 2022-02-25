package date_one;

import java.util.Arrays;

/**
 * @DATE 2022/2/22
 * @Created by zhangzhi
 * 位运算
 */
public class bitOperation {

    //题目1：一个数组中，只有一个数出现奇数次，其他数出现偶数次，找出这个数
    //解法：用异或运算，自己和自己异或为零。零和任何数异或等于本身。
    public static int solution(int[] arr){
        int result = 0;
        for(int val:arr){
            result ^= val;
        }

        return result;
    }


    //题目2：一个数组中，有两个数出现奇数次，找出这两个数
    //解法：同样用异或预算。
    //异或完之后：result = a^b
    /**
     * 因为 a != b，所以 a^b!=0
     * 这个时候就可以从 result 的二进制表示中找到 至少一位是 1
     * 然后根据这个 1 ，可以把数组分为两部分，一部分是该位为1，另一部分不是 1
     * 再异或一次数组，这次只异或 1 的那部分数（或者 0 那部分数）
     * */

    public static int[] solutiontwo(int[] arr){
        int result1 = 0;
        int result2 = 0;
        for(int val: arr){
            result1 ^= val;
        }

        //这是一个小技巧。这样就可以找到最右边的那个 1
        //rightOne的形式为: 00001000
        int rightOne = result1&(~result1 + 1);
        for(int val:arr){
            //其他数与rightOne做与运算，就可以区分出来
            if((val&rightOne) == rightOne){
                result2 ^= val;
            }
        }
        //result2就是其中的一个数，再和result1异或，就可以得到第二个数
        return new int[]{result2,result1^result2};
    }

    public static void main(String[] args) {
//        int[] arr = {1,1,2,2,3,3,3,4,4,4,4};
//        System.out.println(solution(arr));
        int[] arr = {1,1,1,1,1,3,3,3,3,4,4,5,5,5};
        System.out.println(Arrays.toString(solutiontwo(arr)));
    }
}
