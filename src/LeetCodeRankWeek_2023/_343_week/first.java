package LeetCodeRankWeek_2023._343_week;

// @date 2023/4/30
// @time 10:23
// @author zhangzhi
// @description
public class first {
    public int isWinner(int[] player1, int[] player2) {
        if(player1.length == 1){
            if(player1[0] == player2[0]){
                return 0;
            }else if(player1[0] > player2[0]){
                return 1;
            }else{
                return 2;
            }
        }
        int score1 = 0;
        int score2 = 0;
        if(player1[0] == 10){
            score1 += player1[1] * 2 + player1[0];
        }else {
            score1 += player1[1] + player1[0];
        }
        if(player2[0] == 10){
            score2 += player2[1] * 2 + player2[0];
        }else {
            score2 += player2[1] + player2[0];
        }
        int len = player1.length;
        for(int i = 2; i < len; i++){
            if(player1[i - 1] == 10 || player1[i - 2] == 10){
                score1 += player1[i] * 2;
            }else{
                score1 += player1[i];
            }
            if(player2[i - 1] == 10 || player2[i - 2] == 10){
                score2 += player2[i] * 2;
            }else{
                score2 += player2[i];
            }
        }
        if(score1 == score2){
            return 0;
        } else if (score1 > score2) {
            return 1;
        }else {
            return 2;
        }
    }
}
