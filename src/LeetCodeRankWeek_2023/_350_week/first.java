package LeetCodeRankWeek_2023._350_week;

// @date 2023/6/18
// @time 10:27
// @author zhangzhi
// @description
public class first {

    public int distanceTraveled(int mainTank, int additionalTank) {
        int total = 0;
        while(mainTank > 0){
            if(mainTank >= 5){
                mainTank -= 5;
                total += 50;
                if(additionalTank > 0){
                    mainTank += 1;
                    additionalTank -= 1;
                }
            }else{
                mainTank -= 1;
                total += 10;
            }
        }
        return total;
    }
}
