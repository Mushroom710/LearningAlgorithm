package LeetCodeRankWeek_2023._342_week;

// @date 2023/4/23
// @time 10:13
// @author zhangzhi
// @description
public class first {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
