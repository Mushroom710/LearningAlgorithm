package AutumnPlan_2022.day_10_7;

// @date 2022/10/7
// @time 15:05
// @author zhangzhi
// @description LeetCode 1237 题 找出给定方程的正整数解
// 1 <= x, y <= 1000
// 区间确定了，就确定一个，二分另一个，逐个击破

import java.util.LinkedList;
import java.util.List;

interface CustomFunction{
    public int f(int x,int y);
}

class CustomFunctionA implements CustomFunction{
    public int f(int x,int y){
        return x * y;
    }
}

public class FindPositiveIntegerSolutionForAGivenEquation {


    private static List<Integer> binarySearch(int x,int z,CustomFunction customFunction){
        List<Integer> result = new LinkedList<>();
        int left = 1;
        int right = 1000;
        while (left <= right){
            int y = left + (right - left) / 2;
            int tmp = customFunction.f(x,y);
            if(z == tmp){
                result.add(x);
                result.add(y);
                return result;
            }else if(z < tmp){
                right = y - 1;
            }else {
                left = y + 1;
            }
        }
        return result;
    }

    public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new LinkedList<>();

        for(int x = 1; x <= 1000;x++){
            List<Integer> result = binarySearch(x,z,customfunction);
            if(result.size() == 0){
                continue;
            }
            ans.add(result);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findSolution(new CustomFunctionA(),5));
    }
}
