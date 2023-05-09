package AutumnPlan_2023.May.day_5_9;

// @date 2023/5/9
// @time 22:27
// @author zhangzhi
// @description LeetCode 2437. 有效时间的数目
public class NumberOfValidClockTimes {
    public int countTime(String time) {
        char[] ch = time.toCharArray();
        int ans = 1;
        if(ch[4] == '?'){
            ans *= 10;
        }
        if(ch[3] == '?'){
            ans *= 6;
        }
        if(ch[0] == '?' && ch[1] == '?'){
            ans *= 24;
        }else if(ch[1] == '?'){
            if(ch[0] == '2'){
                ans *= 4;
            }else{
                ans *= 10;
            }
        }else if(ch[0] == '?'){
            if(ch[1] <= '3'){
                ans *= 3;
            }else{
                ans *= 2;
            }
        }
        return ans;
    }
}
