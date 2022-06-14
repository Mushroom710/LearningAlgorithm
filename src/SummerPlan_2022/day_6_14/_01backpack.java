package SummerPlan_2022.day_6_14;

/**
 * @DATE 2022/6/14
 * @TIME 19:11
 * @Created by zhangzhi
 * @description 01 背包理论基础
 */
public class _01backpack {

    /**
     * @create zhangzhi
     * @date 2022/6/14
     * @time 19:29
     * @description
     * dp[i][j]的含义：从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
     * 1.不放物品i：由dp[i - 1][j]推出，即背包容量为j，里面不放物品i的最大价值，
     *  此时dp[i][j]就是dp[i - 1][j]。
     *  (其实就是当物品i的重量大于背包j的重量时，物品i无法放进背包中，所以被背包内的价值依然和前面相同。)
     * 2.放物品i：由dp[i - 1][j - weight[i]]推出，
     *  dp[i - 1][j - weight[i]] 为背包容量为j - weight[i]的时候不放物品i的最大价值，
     *  那么dp[i - 1][j - weight[i]] + value[i] （物品i的价值），就是背包放物品i得到的最大价值
     *  j - weight[i] 表示容量为 j - weight[i] 的背包所背的最大价值。
     */
    public static int _0_1_pack(int back_weight,int[] weight,int[] value){
        int[][] dp = new int[weight.length][back_weight + 1];
        for (int j = weight[0];j <= back_weight;j++){
            dp[0][j] = value[0];
        }
        for (int i = 1;i < weight.length;i++){//遍历物品
            for (int j = 0;j <= back_weight;j++){// 遍历背包容量
                if (j < weight[i])dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[weight.length - 1][back_weight];
    }

    /**
     * @create zhangzhi
     * @date 2022/6/14
     * @time 19:40
     * @description 状态压缩写法
     * line_51 倒序遍历的原因是，本质上还是一个对二维数组的遍历，并且右下角的值依赖上一层左上角的值，
     * 因此需要保证左边的值仍然是上一层的，从右向左覆盖。
     */
    public static int _0_1_back_one(int back_weight,int[] weight,int[] value){
        int[] dp = new int[back_weight + 1];
        for (int i = 0;i < weight.length;i++){// 遍历物品
            for (int j = back_weight;j >= weight[i];j--){// 遍历背包容量
                dp[j] = Math.max(dp[j],dp[j - weight[i]] + value[i]);
            }
        }
        return dp[back_weight];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{1,3,4};
        int[] value  = new int[]{15,20,30};
        System.out.println(_0_1_pack(4,weight,value));
        System.out.println(_0_1_back_one(4,weight,value));
    }
}
