package SummerPlan_2022.day_6_13;

/**
 * @DATE 2022/6/13
 * @TIME 18:10
 * @Created by zhangzhi
 * @description LeetCode 96 题 不同的二叉搜索树
 * 1.确定dp数组（dp table）以及下标的含义
 *  dp[i] ： 1到 i 为节点组成的二叉搜索树的个数为 dp[i]。
 *  也可以理解是i的不同元素节点组成的二叉搜索树的个数为 dp[i] ，都是一样的。
 * 以下分析如果想不清楚，就来回想一下dp[i]的定义
 * 2.确定递推公式
 *  在上面的分析中，其实已经看出其递推关系，
 *  dp[i] += dp[以j为头结点左子树节点数量] * dp[以j为头结点右子树节点数量]
 *  j 相当于是头结点的元素，从 1 遍历到 i 为止。
 *
 * 所以递推公式：dp[i] += dp[j - 1] * dp[i - j];
 * j-1 为 j 为头结点左子树节点数量，i-j 为以 j 为头结点右子树节点数量
 */
public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= i;j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
}
