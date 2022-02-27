package LeetCodeRankWeek.week;

import java.util.ArrayList;

/**
 * @DATE 2022/2/26
 * @Created by zhangzhi
 */
public class four {

    //错误思路。没必要算阶乘
    public static long product(int n,int m){
        long pro = 1;
        long pnm = 1;
        long pm = 1;
        long pn = 1;
        for(int i=1;i<=n;i++){
            pro *=i;
            if(i == (n-m)){
                pnm = pro;
            }else if(i == m){
                pm = pro;
            }else if(i == n){
                pn = pro;
            }
        }
        System.out.println(pn+"     "+pm+"  "+pnm);
        return pn/(pm*pnm) + n*(n-1)/2;
    }


    public static long solution(int[] nums,int k){
        int countk = 0;//统计有多少个整除k的数
        for(int num:nums){
            if(num%k == 0){
                countk += 1;
            }
        }

        return (long) countk *(nums.length-countk)+ (long) countk *(countk-1)/2;
    }

    public static long solution_second(int[] nums,int k){
        int countk = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]%k == 0){
                countk +=1;
                continue;
            }
            if(i == nums.length - 1){
                break;
            }
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]%k!=0&&(nums[i]*nums[j])%k == 0){
                    count += 1;
                }
            }
        }
        return (long) countk *(nums.length-countk)+ (long) countk *(countk-1)/2 + count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,10,2,5,9,6,3,8,2};
        System.out.println(solution(nums,6));
        System.out.println(solution_second(nums,6));
    }
}
