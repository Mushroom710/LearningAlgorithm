package AutumnPlan_2023.April.lccup_2023;

import java.util.Arrays;

// @date 2023/4/22
// @time 14:50
// @author zhangzhi
// @description
public class first {
    public static int[] supplyWagon(int[] supplies) {
        int len = supplies.length;
        int cut = len / 2;
        while (supplies.length > cut){
            int min = supplies[0] + supplies[1];
            int idx = 0;
            for(int i = 1; i < supplies.length - 1; i++){
                if(supplies[i] + supplies[i + 1] < min){
                    min = supplies[i] + supplies[i + 1];
                    idx = i;
                }
            }
            int[] newSup = new int[supplies.length - 1];
            int k = 0;
            for(int i = 0; i < newSup.length; i++){
                if(i != idx){
                    newSup[i] = supplies[k++];
                }else{
                    newSup[i] = min;
                    k += 2;
                }
            }
            supplies = newSup;
        }
        return supplies;
    }

    public static void main(String[] args) {
        int[] supplies = new int[]{1,3,1,5};
        System.out.println(Arrays.toString(supplyWagon(supplies)));
    }
}
