package AutumnPlan_2023.April.lccup_2023;

import java.util.HashSet;
import java.util.Set;

// @date 2023/4/22
// @time 14:50
// @author zhangzhi
// @description
public class second {
    public static int adventureCamp(String[] expeditions) {
        Set<String> set = new HashSet<>();
        int max = 0;
        int idx = 0;
        String[] sites = expeditions[0].split("->");
        for(String site : sites){
            set.add(site);
        }
        for(int i = 1; i < expeditions.length; i++){
            sites = expeditions[i].split("->");
            int newSite = 0;
            for(String site : sites){
                if(!"".equals(site) && !set.contains(site)){
                    set.add(site);
                    newSite += 1;
                }
            }
            if(newSite > max){
                max = newSite;
                idx = i;
            }
        }
        return max == 0 ? -1 : idx;
    }

    public static void main(String[] args) {
        String[] sites = new String[]{"Alice->Dex","","Dex"};
        System.out.println(adventureCamp(sites));
    }
}
