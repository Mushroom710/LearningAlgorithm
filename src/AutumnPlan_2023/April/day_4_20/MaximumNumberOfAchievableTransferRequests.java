package AutumnPlan_2023.April.day_4_20;

// @date 2023/4/20
// @time 21:35
// @author zhangzhi
// @description LeetCode 1601. 最多可达成的换楼请求数目 hard
public class MaximumNumberOfAchievableTransferRequests {
    // rooms 表示这个房子的人数
    // 搬出就 -1，搬入就 +1
    // 在 re > 0 时，说明至少有一个换房请求，这个时候就看这个rooms是否全为 0
    // 如果全为 0，说明这些换房请求都是可以满足的，记录答案
    private int[] rooms;
    private int[][] requests;
    private int n;
    // 换房请求数取最大的
    private int ans;

    // re 是换房请求数，初始为 0
    // i 是第几个换房请求
    private void dfs(int i, int re){
        if(re > 0){
            // 用于标记 rooms 是否全为 0
            // 不是全为 0，就改为 true
            boolean flag = false;
            for(int k = 0; k < n; k++){
                if(rooms[k] != 0){
                    flag = true;
                }
            }
            // 如果全为 0，说明 re 数量的换房请求可以满足，取最大值
            if(!flag){
                ans = Math.max(ans, re);
            }
        }
        // 递归边界
        if(i == requests.length){
            return;
        }

        dfs(i + 1, re);

        rooms[requests[i][0]] -= 1;
        rooms[requests[i][1]] += 1;
        dfs(i + 1, re + 1);
        rooms[requests[i][0]] += 1;
        rooms[requests[i][1]] -= 1;

        // // 枚举换房请求
        // for(int j = i; j < requests.length; j++){
        //     // 搬出的房子 -1
        //     rooms[requests[j][0]] -= 1;
        //     // 搬入的房子 +1
        //     rooms[requests[j][1]] += 1;
        //     dfs(j + 1, re + 1);
        //     rooms[requests[j][0]] += 1;
        //     rooms[requests[j][1]] -= 1;
        // }

    }

    public int maximumRequests(int n, int[][] requests) {
        this.rooms = new int[n];
        this.requests = requests;
        this.n = n;
        // 0 说明不能达成换房请求
        this.ans = 0;
        dfs(0, 0);
        return ans;
    }
}
