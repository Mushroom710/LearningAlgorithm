package AutumnPlan_2023.June.day_6_11;

import java.util.*;

// @date 2023/6/11
// @time 9:57
// @author zhangzhi
// @description LeetCode 49. 字母异位词分组
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, new ArrayList<>(list));
        }
        return new ArrayList<>(map.values());
    }
}
