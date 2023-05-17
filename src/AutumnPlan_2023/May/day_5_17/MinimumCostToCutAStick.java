package AutumnPlan_2023.May.day_5_17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// @date 2023/5/17
// @time 10:25
// @author zhangzhi
// @description LeetCode 1547. 切棍子的最小成本
// 我又学到了一种写记忆化的方式。就像之前说的：记忆化的本质就是同样的参数可以得到同样的结果。
// 那么我可以通过拼接参数来构造一个key，存入map中。虽然慢了点，但对与这道题，非常有效的解决了OOM问题。
// 这题如果直接用数组做记忆化，会超出内存的限制。因为这题的 n 可以到 10^6，开一个10^6*10^6的二维数组，显然会超内内存，
// 所以要转换记忆化的方式，采用 map 来做记忆化。
// 用 map 做记忆化要解决一个问题，就是对于多参数的递归，我怎么构造对应的 key 来保证一一对应呢？
// 这就可以用拼接参数的方式来构造 key 了。

public class MinimumCostToCutAStick {
    private int[] cutsp;
    private int[][] cache;

    private int dfs(int i, int j){
        if(cache[i][j] != -1){
            return cache[i][j];
        }
        if(i + 1 == j){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k++){
            res = Math.min(res, dfs(i, k) + dfs(k, j));
        }
        return cache[i][j] = (res == Integer.MAX_VALUE ? 0 : res + cutsp[j] - cutsp[i]);
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        this.cutsp = new int[cuts.length + 2];
        System.arraycopy(cuts, 0, this.cutsp, 1, cuts.length);
        this.cutsp[cuts.length + 1] = n;
        this.cache = new int[102][102];
        for(int[] ca : cache){
            Arrays.fill(ca, -1);
        }
        return dfs(0, this.cutsp.length - 1);
    }


    private int[] cuts;
    private Map<String, Integer> cache2;

    private int dfs2(int i, int j){
        String key = i + "-" + j;
        if(cache2.containsKey(key)){
            return cache2.get(key);
        }
        int res = Integer.MAX_VALUE;
        for(int cut : cuts){
            if(cut > i && cut < j){
                res = Math.min(res, dfs2(i, cut) + dfs2(cut, j));
            }
        }
        int ans = res == Integer.MAX_VALUE ? 0 : res + j - i;
        cache2.put(key, ans);
        return ans;
    }

    public int minCost2(int n, int[] cuts) {
        //Arrays.sort(cuts);
        this.cuts = cuts;
        this.cache2 = new HashMap<>();
        return dfs2(0, n);
    }

    public static void main(String[] args) {
        int[] cuts = new int[]{1, 3, 4, 5};
        System.out.println(new MinimumCostToCutAStick().minCost(7, cuts));
    }
}
