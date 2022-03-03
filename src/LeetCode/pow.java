package LeetCode;

/**
 * @DATE 2022/3/3
 * @Created by zhangzhi
 * @description LeetCode50 题
 * 计算 pow(x,n)，即 x 的 n 次方
 * n 可能是负数
 *
 * 1.直接调用库函数 pow(x,n)
 * 2.暴力计算 x*x...x
 * 3.分治法。
 * 可以对上面一种进行优化，每次只算一半，即 y = pow(x,n/2)
 * 所以 result = y*y
 * n 为奇数时，result = y*y*x
 * 也就是拿走一个 x，n-1就是偶数了，就可以对半分
 */
public class pow {

    /**
     * @return double
     * @create zhangzhi
     * @date 2022/3/3
     * @time 10:44
     * @description 分治法，每次只需要计算一半的 n 即可
     * 即
     * x^n => x^(n/2) => x^(n/4) ===> x^1 or x^0
     * 然后返回即可
     *
     * 注意考虑整数溢出的问题，即 int [-2^21,2^31-1]
     * 当传入 -2^31时，执行 -n 时，会溢出
     */
    public static double solution(double x,long n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 1/solution(x,-n);
        }
        if(n%2 == 1){
            //当n为奇数时，就用 n-1 进行分治。这样就可以处理 n 为奇数的情形
            return x * solution(x,n-1);
        }
        return solution(x*x,n/2);
    }

    public static double mypow(double x,int n){
        long N = n;
        return solution(x,N);
    }
    /**
     * @param
     * @return a
     * @create zhangzhi
     * @date 2022/3/3
     * @time 10:55
     * @description 分治的非递归写法
     * 注意考虑整数溢出的问题，即 int [-2^21,2^31-1]
     * 当传入 -2^31时，执行 -n 时，会溢出
     */
    public static double solution_two(double x,int n){
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        double pow = 1;
        while(n>0){
            //关键：判断 n 是 2^? 的多少次方
            //也就是区分出 n为 奇数 or 偶数
            //pow 可以保存 2^n 次方时，x的值
            if((n&1) == 1){//1,3,5,7....
                pow *= x;
            }
            x *= x;//2^0,2^1,2^2,2^3....
            n >>=1;//n 减半
        }
        return pow;
    }
    public static void main(String[] args) {
        System.out.println(mypow(1,-2147483648));
        System.out.println(solution_two(-1,2147483647));
    }
}
