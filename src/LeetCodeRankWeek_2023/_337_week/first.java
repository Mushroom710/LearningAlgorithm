package LeetCodeRankWeek_2023._337_week;

// @date 2023/3/19
// @time 10:25
// @author zhangzhi
// @description

import java.util.Arrays;

public class first {

    public static int[] evenOddBit(int n) {
        char[] bin = Integer.toBinaryString(n).toCharArray();
        int[] ans = new int[2];
        int len = bin.length;
        int left = 0;
        int right = len - 1;
        while(left <= right){
            char tmp = bin[left];
            bin[left] = bin[right];
            bin[right] = tmp;
            left++;
            right--;
        }
        for(int i = 0; i < len; i++){
            if(i %  2 == 0 && bin[i] == '1'){
                ans[0]++;
            }else if(bin[i] == '1'){
                ans[1]++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = evenOddBit(4);
        System.out.println(Arrays.toString(ints));
    }
}
