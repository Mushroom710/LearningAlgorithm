package AutumnPlan_2023.May.day_5_5;

// @date 2023/5/5
// @time 20:53
// @author zhangzhi
// @description 每日一题 LeetCode 2432. 处理用时最长的那个任务的员工
public class TheEmployeeThatWorkedOnTheLongestTask {
    // 根据题目的意思枚举每一个任务
    // 题意就是找出 min{logs[i][1] - logs[i - 1][1]}最大且同时保证 logs[i][0] 最小
    public int hardestWorker(int n, int[][] logs) {
        int id = logs[0][0];
        int time = logs[0][1];
        for(int i = 1; i < logs.length; i++){
            int cap = logs[i][1] - logs[i - 1][1];
            if(time < cap){
                time = cap;
                id = logs[i][0];
            }else if(time == cap && id > logs[i][0]){
                id = logs[i][0];
            }
        }
        return id;
    }
}
