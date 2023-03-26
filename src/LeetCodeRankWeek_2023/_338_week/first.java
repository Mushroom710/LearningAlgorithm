package LeetCodeRankWeek_2023._338_week;

// @date 2023/3/26
// @time 10:17
// @author zhangzhi
// @description

public class first {

    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(numOnes >= k){
            return k;
        }else{
            int diff = k - numOnes;
            if(numZeros >= diff){
                return numOnes;
            }else {
                diff = diff - numZeros;
                return numOnes - diff;
            }
        }
    }
}
