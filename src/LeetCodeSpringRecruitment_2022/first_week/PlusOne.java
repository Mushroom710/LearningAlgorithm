package LeetCodeSpringRecruitment_2022.first_week;

import java.util.Arrays;

/**
 * @DATE 2022/3/19
 * @TIME 20:13
 * @Created by zhangzhi
 * @description LeetCode 66 题 加一
 */
public class PlusOne {

    public static int[] solution(int[] digits){
        if(digits[digits.length - 1] == 9){
            int carry = 0;
            int[] ans = new int[digits.length + 1];
            for(int i = digits.length - 1; i > 0; i--){
                if(digits[i] == 9){
                    ans[i] = 0;
                    carry = 1;
                }else {
                    ans[i + 1] = digits[i] + carry;
                    carry = 0;
                }
            }
            if(digits[0] == 9 && carry == 1){
                ans[0] = 1;
                return ans;
            }
            ans[1] = digits[0] + carry;
            return Arrays.copyOfRange(ans,1,ans.length);
        }else{
            digits[digits.length - 1] += 1;
            return digits;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{8,9,9,9})));
    }
}
