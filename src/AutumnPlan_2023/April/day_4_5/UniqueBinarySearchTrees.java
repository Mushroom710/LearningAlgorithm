package AutumnPlan_2023.April.day_4_5;

// @date 2023/4/5
// @time 22:09
// @author zhangzhi
// @description LeetCode 96. 不同的二叉搜索树
// 假设f(n)表示n个节点的二叉搜索树的数量。我们可以将问题分解成更小的子问题。
// 考虑如果以i为根节点，那么它的左子树有 i-1 个节点，右子树有 n-i 个节点。
// 因此，以i为根节点的二叉搜索树的数量为左右子树的数量的乘积，即f(i-1)*f(n-i)。

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
