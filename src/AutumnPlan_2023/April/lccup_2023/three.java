package AutumnPlan_2023.April.lccup_2023;

import java.util.*;

// @date 2023/4/22
// @time 15:34
// @author zhangzhi
// @description
public class three {

    public static int fieldOfGreatestBlessing(int[][] forceField) {
        int len = forceField.length;
        double[][] rectangle = new double[len][4];
        for(int i = 0; i < len; i++){
            double d = forceField[i][2] / 2.0;
            for(int j = 0; j < 4; j++){
                rectangle[i][0] = forceField[i][0] - d;
                rectangle[i][1] = forceField[i][1] - d;
                rectangle[i][2] = forceField[i][0] + d;
                rectangle[i][3] = forceField[i][1] + d;
            }
        }
        int[] ans = new int[len];
        // Arrays.fill(ans, 1);
        //Map<Integer, List<Integer>> map = new HashMap<>();
        //int result = ans[0];
        for(int i = 0; i < len; i++){
            //List<Integer> list = new ArrayList<>();
            for(int j = 0; j < len; j++){
                boolean x = !(rectangle[i][2] < rectangle[j][0] || rectangle[j][2] < rectangle[i][0]);
                boolean y = !(rectangle[i][3] < rectangle[j][1] || rectangle[j][3] < rectangle[i][1]);
                if(x && y){
                    //list.add(j);
                    ans[i]++;
                }
            }
            //map.put(i, list);
        }
        System.out.println(Arrays.toString(ans));

//        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
//            List<Integer> list = entry.getValue();
//            if(list.size() != 0){
//                for(int num : list){
//                    result = Math.max(result, ans[num] + 1);
//                }
//            }
//        }
        int left = 0;
        int right = 0;
        int count = 1;
        int result = ans[0];
        Arrays.sort(ans);
        while(right < len && left <= right){
            if(ans[left] == ans[right]){
                right++;
            }else{
                if(count <= right - left){
                    count = right - left;
                    result = ans[left];
                    left = right;
                }else{
                    left = right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] force = new int[][]{{7,7,9},{7,5,3},{1,8,5},{5,6,3},{9,10,2},{8,4,10}};
        System.out.println(fieldOfGreatestBlessing(force));
    }
}
