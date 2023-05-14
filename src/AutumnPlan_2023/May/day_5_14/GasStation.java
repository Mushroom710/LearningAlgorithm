package AutumnPlan_2023.May.day_5_14;

// @date 2023/5/14
// @time 22:11
// @author zhangzhi
// @description LeetCode 134. 加油站
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0;
        int sum = 0;
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0){
                ans = i + 1;
                sum = 0;
            }
        }
        return total < 0 ? -1 : ans;
    }
}
