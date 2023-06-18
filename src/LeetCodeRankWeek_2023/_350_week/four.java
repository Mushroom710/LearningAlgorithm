package LeetCodeRankWeek_2023._350_week;

// @date 2023/6/18
// @time 11:36
// @author zhangzhi
// @description
public class four {

    int pay = 0;
    int timePay = 0;
    int timeFree = 0;

    int ans = Integer.MAX_VALUE;

    private void dfs(int[] cost, int[] time, int i){
        if(i == cost.length){
            if(timePay >= timeFree){
                ans = Math.min(ans, pay);
            }
            return;
        }

        pay += cost[i];
        timePay += time[i];
        dfs(cost, time, i + 1);
        pay -= cost[i];
        timePay -= time[i];

        timeFree += 1;
        dfs(cost, time, i + 1);
        timeFree -= 1;
    }

    private void dfs2(int[] cost, int[] time, int i){

    }

    public int paintWalls(int[] cost, int[] time) {
        dfs(cost, time, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{2,3,4,2};
        int[] time = new int[]{1,1,1,1};
        System.out.println(new four().paintWalls(cost, time));
    }
}
