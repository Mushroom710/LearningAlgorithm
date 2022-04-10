package LeetCodeRankWeek._288_week;

import java.util.Arrays;
import java.util.Map;

/**
 * @DATE 2022/4/10
 * @TIME 10:26
 * @Created by zhangzhi
 * @description
 */
public class first {

    public static int solution(int num){
        char[] sNum = String.valueOf(num).toCharArray();
        int len = sNum.length;
        int[][] arr = new int[2][len];
        int odd = 0;
        int even = 0;
        for (char c : sNum) {
            if (c % 2 == 0) {
                even++;
            }
        }
        odd = len - even;
        int[] odds = new int[odd];
        int[] evens = new int[even];
        int oIdx = 0;
        int eIdx = 0;
        for(int i = 0; i < len; i++){
            if(sNum[i] % 2 == 0){
                evens[eIdx] = sNum[i] - 48;
                arr[1][i] = 0;
                eIdx++;
            }else {
                odds[oIdx] = sNum[i] - 48;
                oIdx++;
                arr[1][i] = 1;
            }
        }
        Arrays.sort(odds);
        Arrays.sort(evens);
        oIdx = odd - 1;
        eIdx = even - 1;
        for(int i = 0; i < len; i++){
            if(arr[1][i] == 0){
                arr[0][i] =  evens[eIdx];
                eIdx--;
            }else {
                arr[0][i] =  odds[oIdx];
                oIdx--;
            }
        }
        int ans = arr[0][len - 1];
        int pow = 10;
        for(int i = len - 2; i >= 0;i--) {
            ans += arr[0][i] * pow;
            pow *= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        int num = 1234;
        System.out.println(solution(num));
    }
}
