package AutumnPlan_2023.May.day_5_31;

import java.util.HashMap;
import java.util.Map;

// @date 2023/5/31
// @time 10:00
// @author zhangzhi
// @description LeetCode 205. 同构字符串

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(!smap.containsKey(sch) && !tmap.containsKey(tch)){
                smap.put(sch, tch);
                tmap.put(tch, sch);
            }else{
                if(!tmap.containsKey(tch)){
                    return false;
                }
                char tMapping = tmap.get(tch);
                if(tMapping != sch){
                    return false;
                }
            }
        }
        return true;
    }
}
