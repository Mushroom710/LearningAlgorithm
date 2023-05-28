package LeetCodeRankWeek_2023._347_week;

// @date 2023/5/28
// @time 10:21
// @author zhangzhi
// @description
public class first {
    public String removeTrailingZeros(String num) {
        int idx = num.length() - 1;
        for(;idx >= 0; idx--){
            if(num.charAt(idx) != '0'){
                break;
            }
        }
        return num.substring(0, idx + 1);
    }

    public static void main(String[] args) {
        System.out.println(new first().removeTrailingZeros("512300"));
    }
}
