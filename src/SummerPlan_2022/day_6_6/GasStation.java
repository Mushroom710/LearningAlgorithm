package SummerPlan_2022.day_6_6;

/**
 * @DATE 2022/6/6
 * @TIME 22:37
 * @Created by zhangzhi
 * @description LeetCode 134 题 加油站
 */
public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length;i++){
            int rest = gas[i] - cost[i];
            int index = (i + 1) % cost.length;
            while (rest > 0 && index != i){
                rest += gas[index] - cost[index];
                index = (index + 1) % cost.length;
            }
            if (rest >= 0 && index == i)return i;
        }
        return -1;
    }

    /**
     * @create zhangzhi
     * @date 2022/6/6
     * @time 22:51
     * @description 感觉特像周赛的题
     * 首先如果总油量减去总消耗大于等于零那么一定可以跑完一圈，
     * 说明 各个站点的加油站 剩油量 rest[i]相加一定是大于等于零的。
     * 每个加油站的剩余量 rest[i]为 gas[i] - cost[i]。
     * i从 0开始累加 rest[i]，和记为 curSum，一旦 curSum小于零，
     * 说明 [0, i] 区间都不能作为起始位置，起始位置从 i+1 算起，再从 0 计算 curSum
     * 那么为什么一旦 [i，j] 区间和为负数，起始位置就可以是 j+1 呢，j+1 后面就不会出现更大的负数？
     * 如果出现更大的负数，就是更新 j，那么起始位置又变成新的 j+1 了。
     * 而且 j 之前出现了多少负数，j 后面就会出现多少正数，因为耗油总和是大于零的（前提我们已经确定了一定可以跑完全程）。
     * 那么局部最优：当前累加 rest[j]的和 curSum 一旦小于 0，起始位置至少要是 j+1，
     * 因为从 j 开始一定不行。全局最优：找到可以跑一圈的起始位置。
     */
    public static int right_solution_one(int[] gas,int[] cost){
        int start = 0;
        int curSum = 0;
        int totalSum = 0;
        for (int i = 0;i < gas.length;i++){
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0){
                start = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0)return -1;
        return start;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
        System.out.println(right_solution_one(gas,cost));
    }
}
