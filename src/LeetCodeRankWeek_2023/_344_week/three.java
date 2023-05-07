package LeetCodeRankWeek_2023._344_week;

import java.lang.reflect.Array;
import java.util.Arrays;

// @date 2023/5/7
// @time 11:21
// @author zhangzhi
// @description
// 这道题只要想到涂色后，只会影响相邻位置的元素，其他位置不会影响到，就解出 50% 了
// 剩下的就是怎么把代码写的简洁。
public class three {
    public static int[] colorTheArray(int n, int[][] queries) {
        int len = queries.length;
        int[] nums = new int[n + 2]; // 处理数组越界的思路
        int[] ans = new int[len];
        int cnt = 0;
        for(int k = 0; k < len; k++ ){
            int i = queries[k][0] + 1;// 索引 + 1  避免-1操作越界
            int color = queries[k][1];
            // 可以先去掉当前元素对 cnt 的影响，修改颜色后，再加上当前元素对 cnt 的影响。
            if(nums[i] > 0){
                // 先减去，后面在加回来，
                cnt -= (nums[i - 1] == nums[i] ? 1 : 0) + (nums[i] == nums[i + 1] ? 1 : 0);
            }
            nums[i] = color;
            cnt += (nums[i - 1] == nums[i] ? 1 : 0) + (nums[i] == nums[i + 1] ? 1 : 0);
            ans[k] = cnt;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] queries = new int[][]{{0,2},{1,2},{3,1},{1,1},{2,1}};
        System.out.println(Arrays.toString(colorTheArray(4 , queries)));
    }
}
